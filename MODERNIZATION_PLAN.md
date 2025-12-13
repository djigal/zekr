# Plan de Modernisation de Zekr

**Date de début:** 13 décembre 2025
**Objectif:** Moderniser l'application Zekr tout en conservant ses fonctionnalités

## 📋 Vue d'ensemble

### État actuel
- **Langage:** Java 1.5
- **Build:** Apache Ant
- **GUI:** SWT (Standard Widget Toolkit)
- **Bibliothèques:**
  - Lucene 3.0.0 (2010)
  - Velocity 1.6.2 (2010)
  - Log4j 1.2.8 (2005)
  - Commons libraries (2008-2009)

### État cible
- **Langage:** Java 17 LTS ou Java 21 LTS
- **Build:** Maven ou Gradle
- **GUI:** JavaFX 21
- **Bibliothèques:**
  - Lucene 9.x
  - Velocity 2.x ou Thymeleaf
  - SLF4J + Logback
  - Commons libraries actualisées

## 🎯 Phase 1: Préparation et Migration Build (2-3 semaines)

### Étape 1.1: Restructuration du projet ✅
- [x] Extraire le code source de `dist/zekr-src.jar`
- [x] Créer structure Maven standard:
  ```
  src/
    main/
      java/          ← Code source
      resources/     ← Fichiers .properties, config, etc.
    test/
      java/          ← Tests unitaires
  ```

### Étape 1.2: Migration vers Maven
- [ ] Créer `pom.xml` avec toutes les dépendances
- [ ] Configurer les plugins Maven (compiler, resources, jar)
- [ ] Tester que la compilation Maven fonctionne
- [ ] Supprimer `build.xml` une fois Maven validé

### Étape 1.3: Mise à jour Java
- [ ] Passer à Java 11 d'abord (transition)
- [ ] Corriger les warnings de compilation
- [ ] Puis passer à Java 17 LTS
- [ ] Utiliser les nouvelles APIs Java (var, records si pertinent, etc.)

## 🎯 Phase 2: Mise à jour des dépendances (3-4 semaines)

### Étape 2.1: Logging
**Avant:**
```java
import org.apache.log4j.Logger;
Logger logger = Logger.getLogger(MyClass.class);
```

**Après:**
```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
Logger logger = LoggerFactory.getLogger(MyClass.class);
```

- [ ] Remplacer Log4j 1.2.8 par SLF4J + Logback
- [ ] Migrer tous les appels de logging
- [ ] Configurer `logback.xml`

### Étape 2.2: Lucene (Search Engine)
**Migration complexe:**
- [ ] Lucene 3.0.0 → Lucene 9.x
- [ ] Réécrire les analyseurs et query parsers
- [ ] Réindexer toutes les données
- [ ] Tester la recherche en profondeur

### Étape 2.3: Velocity Template Engine
**Options:**
1. Mettre à jour vers Velocity 2.x
2. Migrer vers Thymeleaf (plus moderne)

- [ ] Choisir l'option (recommandé: garder Velocity 2.x pour simplicité)
- [ ] Mettre à jour les templates si nécessaire
- [ ] Tester le rendu HTML

### Étape 2.4: Apache Commons
- [ ] Mettre à jour toutes les bibliothèques Commons
- [ ] Corriger les API changes

### Étape 2.5: Audio
**Problème actuel:** Bibliothèques audio très anciennes (Tritonus, JLayer)

**Solution moderne:**
- [ ] Évaluer JavaFX Media ou Java Sound API moderne
- [ ] Migrer vers une solution plus maintenue
- [ ] Conserver la compatibilité MP3/Ogg

## 🎯 Phase 3: Migration GUI SWT → JavaFX (6-8 semaines)

**C'est la partie la plus complexe**

### Étape 3.1: Analyse de l'existant
- [ ] Lister tous les composants SWT utilisés
- [ ] Identifier les équivalents JavaFX
- [ ] Créer un mapping SWT → JavaFX

### Étape 3.2: Migration progressive par module

**Ordre recommandé:**
1. [ ] Fenêtre principale et layout
2. [ ] Menu et barre d'outils
3. [ ] Affichage du Coran (WebView pour HTML)
4. [ ] Panneau de recherche
5. [ ] Lecteur audio
6. [ ] Gestion des bookmarks
7. [ ] Paramètres/Préférences
8. [ ] About/Help

### Étape 3.3: Utiliser FXML
```xml
<!-- Exemple: MainWindow.fxml -->
<BorderPane xmlns:fx="http://javafx.com/fxml">
    <top>
        <MenuBar>...</MenuBar>
    </top>
    <center>
        <WebView fx:id="quranView"/>
    </center>
    <bottom>
        <HBox>...</HBox>
    </bottom>
</BorderPane>
```

### Étape 3.4: CSS Styling
- [ ] Créer un thème JavaFX moderne
- [ ] Conserver les thèmes existants (Sky, Uthman-Taha)
- [ ] Support mode sombre/clair

## 🎯 Phase 4: Amélioration et Optimisation (2-3 semaines)

### Étape 4.1: Tests
- [ ] Ajouter tests unitaires (JUnit 5)
- [ ] Tests d'intégration pour les modules clés
- [ ] Tests UI avec TestFX

### Étape 4.2: Performance
- [ ] Profiling et optimisation
- [ ] Lazy loading des ressources
- [ ] Améliorer le cache audio

### Étape 4.3: Fonctionnalités modernes
- [ ] Support HiDPI/Retina
- [ ] Shortcuts clavier améliorés
- [ ] Export moderne (PDF, formats actuels)
- [ ] Support multi-fenêtres

## 🎯 Phase 5: Distribution et Packaging (1-2 semaines)

### Étape 5.1: JPackage (Java 14+)
```bash
jpackage --input target/ \
  --name Zekr \
  --main-jar zekr.jar \
  --main-class net.sf.zekr.ZekrMain \
  --type exe  # ou dmg, deb, rpm
```

- [ ] Créer installateurs natifs:
  - Windows: `.exe`, `.msi`
  - macOS: `.dmg`, `.pkg`
  - Linux: `.deb`, `.rpm`, `.AppImage`

### Étape 5.2: GitHub Actions CI/CD
- [ ] Build automatique sur push
- [ ] Tests automatiques
- [ ] Release automatique avec artifacts

## 📊 Estimation totale

**Temps estimé:** 14-18 semaines (3-4 mois)

**Effort par phase:**
- Phase 1: 15%
- Phase 2: 25%
- Phase 3: 45% (la plus complexe)
- Phase 4: 10%
- Phase 5: 5%

## 🚀 Commençons par quoi?

**Recommandation: Phase 1, Étape 1.2 - Migration Maven**

### Avantages de commencer par Maven:
1. ✅ Gestion automatique des dépendances
2. ✅ Structure de projet standard
3. ✅ Facilite la mise à jour des bibliothèques
4. ✅ Intégration IDE parfaite
5. ✅ Prépare le terrain pour toutes les autres phases

### Prochaines actions immédiates:
1. Créer la structure Maven standard
2. Écrire le `pom.xml`
3. Migrer les ressources vers `src/main/resources`
4. Tester la compilation Maven

---

**Voulez-vous que je commence par créer la structure Maven?**
