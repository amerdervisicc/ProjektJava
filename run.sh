#!/bin/bash

# Script för att kompilera och köra Tre-i-rad spelet

echo "=== Kompilerar Tre-i-rad spel ==="
javac src/*.java

if [ $? -eq 0 ]; then
    echo "Kompilering lyckades!"
    echo ""
    echo "=== Startar spelet ==="
    java -cp src Main
else
    echo "Kompilering misslyckades. Kontrollera att Java är installerat."
    exit 1
fi

