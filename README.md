# Tre-i-rad (Tic-Tac-Toe)

Ett text-baserat Tre-i-rad-spel skrivet i Java för två spelare.

## Funktioner

- Spel mellan två mänskliga spelare
- Valfri storlek på spelplanen (minst 3x3)
- Spelarnamn och vinststatistik
- Korrekt felhantering för ogiltiga indata
- Objektorienterad design med separata klasser
- Automatisk omstart efter varje spel

## Projektstruktur

```
src/
├── Main.java    # Huvudklass som startar spelet
├── Game.java    # Hanterar spelets logik och turordning
├── Board.java   # Hanterar spelplanen och vinstkontroll
└── Player.java  # Representerar en spelare med namn och statistik
```

## Kompilering och körning

### Snabbstart
```bash
./run.sh
```

### Manuell kompilering och körning

Kompilera:
```bash
javac src/*.java
```

Kör spelet:
```bash
java -cp src Main
```

## Hur man spelar

1. Starta spelet genom att köra `Main.java`
2. Välj storlek på spelplanen (standard är 3x3)
3. Ange namn för båda spelarna
4. Spelarna turas om att välja en ruta (1-9 för 3x3, eller 1-N för större planer)
5. Första spelaren som får tre i rad (horisontellt, vertikalt eller diagonalt) vinner
6. Efter varje spel kan ni välja att spela igen

## Exempel på spelplan

```
 X | O |  
---+---+---
   | O |
---+---+---
   | X | X 
```

## Kravuppfyllelse

### Grundkrav (Godkänt)
- ✅ Spelbart mellan två människor
- ✅ Kontrollerar och meddelar vinnare/oavgjort
- ✅ Validerar att indata är en tom ruta
- ✅ Startar om efter vinst
- ✅ Kod på engelska
- ✅ Objektorienterad design
- ✅ Strukturerad kod med variabler, strängar, tal, villkorssatser, loopar och funktioner
- ✅ Undviker kodupprepning

### Extra krav (Väl godkänt)
- ✅ Spelarnamn och visar vems tur det är
- ✅ Räknar vinster per spelare
- ✅ Korrekt felhantering
- ✅ Flexibel spelplan (variabel storlek)

## Teknisk information

- **Språk**: Java
- **Design**: Objektorienterad med separata klasser för Board, Player, Game och Main
- **Felhantering**: Try-catch för NumberFormatException och validering av indata
- **Kodstil**: Följer Java-konventioner med engelska namn och kommentarer
