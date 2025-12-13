# Script pour lancer Zekr avec toutes les dépendances

$classpath = "target\classes"

# Ajouter toutes les dépendances
Get-ChildItem -Path "target\lib\*.jar" | ForEach-Object {
    $classpath += ";$($_.FullName)"
}

# Lancer l'application
java -Xms20m -Xmx128m -cp $classpath net.sf.zekr.ZekrMain

