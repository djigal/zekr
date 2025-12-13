# Correction du problème audio Alafasy - Récapitulatif

## Problème identifié

L'audio de la récitation d'Alafasy ne fonctionnait pas pour la récupération des versets et des ayat.

## Causes du problème

### 1. **Bug critique dans AudioCacheManager.java** (PROBLÈME PRINCIPAL)

**Fichier:** `build/src/net/sf/zekr/engine/audio/AudioCacheManager.java`
**Ligne:** 65

**Code buggé:**
```java
String fileUrl = String.format(audioData.getOnlineUrl(sura, aya));
```

**Problème:** 
- La méthode `getOnlineUrl(sura, aya)` retourne déjà une URL formatée
- Exemple: `https://everyayah.com/data/Alafasy_128kbps/001001.mp3`
- Appeler `String.format()` une deuxième fois sur cette URL causait une erreur de formatage
- Les caractères `%` dans l'URL étaient mal interprétés

**Solution appliquée:**
```java
String fileUrl = audioData.getOnlineUrl(sura, aya);
```

### 2. **Faute de frappe dans afasy-128kbps-online.properties**

**Fichier:** `res/audio/afasy-128kbps-online.properties`
**Ligne:** 24

**Avant:**
```properties
audio.offlineBismillam =
```

**Après:**
```properties
audio.offlineBismillah =
```

**Ajout pour la rétrocompatibilité:**
```properties
audio.onlineBismillam = https://everyayah.com/data/Alafasy_128kbps/bismillah.mp3
```

## Fichiers modifiés

1. ✅ `build/src/net/sf/zekr/engine/audio/AudioCacheManager.java`
   - Suppression du double `String.format()`

2. ✅ `res/audio/afasy-128kbps-online.properties`
   - Correction de `offlineBismillam` → `offlineBismillah`
   - Ajout de `onlineBismillam` pour compatibilité

## Comment tester la correction

1. **Compiler le projet:**
   ```bash
   cd C:\Users\djiga\IdeaProjects\zekr
   ant compile
   ```

2. **Redémarrer l'application Zekr**

3. **Sélectionner Alafasy dans les paramètres audio**

4. **Tester la lecture d'un verset:**
   - Ouvrir une sourate
   - Cliquer sur le bouton de lecture audio
   - L'audio devrait maintenant se charger et jouer correctement

## URLs utilisées

L'URL correcte pour Alafasy sur everyayah.com est:
```
https://everyayah.com/data/Alafasy_128kbps/SSSAAA.mp3
```

Où:
- `SSS` = numéro de la sourate sur 3 chiffres (ex: 001, 002, 114)
- `AAA` = numéro de l'ayat sur 3 chiffres (ex: 001, 255, 006)

Exemples:
- Sourate 1, Aya 1: `https://everyayah.com/data/Alafasy_128kbps/001001.mp3`
- Sourate 2, Aya 255 (Ayat al-Kursi): `https://everyayah.com/data/Alafasy_128kbps/002255.mp3`
- Sourate 114, Aya 6: `https://everyayah.com/data/Alafasy_128kbps/114006.mp3`

## Explication technique

Le formatage d'URL en Java avec `String.format()` utilise des placeholders:
- `%1$03d` = premier paramètre formaté sur 3 chiffres avec des zéros devant
- `%2$03d` = deuxième paramètre formaté sur 3 chiffres avec des zéros devant

**Flux correct:**
```
Template: https://everyayah.com/data/Alafasy_128kbps/%1$03d%2$03d.mp3
         ↓ String.format(template, 1, 1)
Résultat: https://everyayah.com/data/Alafasy_128kbps/001001.mp3
```

**Flux buggé (AVANT la correction):**
```
Template: https://everyayah.com/data/Alafasy_128kbps/%1$03d%2$03d.mp3
         ↓ getOnlineUrl(1, 1) [fait déjà String.format()]
Résultat: https://everyayah.com/data/Alafasy_128kbps/001001.mp3
         ↓ String.format() [ERREUR - 2ème formatage!]
CRASH!
```

## Date de correction
13 décembre 2025

