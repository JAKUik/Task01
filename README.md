# Řešený příklad - Solved example - JAVA

## Zpracování úkolu ze vstupního pohovoru 
Příklad vypracovány samostatně Jaroslavem Kučerou. 
Původní zadání bylo pro zpracování v jazyce Python. 

## Obecně
- Úkol bude vypracován v jazyce JAVA.
- Internet je možné používat k čemukoliv, kromě živé konzultace s jinými osobami.
- Hodnocen bude váš přístup k zadání (zejm. analýza), splnění požadavků, robustnost 
  programu a čistota kódu

## Zadání úkolu - Rekurze:
Napište funkci ``word_chain``, která na vstupu dostane libovolně velkou množinu 
slov a vrátí největší počet slov, které lze zřetězit jeden po druhém tak, že 
první písmeno druhého slova je stejné jako poslední písmeno prvního slova. 
Opakování slov není povoleno.

### Příklady:

``` JAVA
Set<String> words = new HashSet<>(Arrays.asList("goose", "dog", "ethanol"));
System.out.println(wordChain(words));
// dog – goose – ethanol

words = new HashSet<>(Arrays.asList("why", "new", "neural", "moon"));
System.out.println(wordChain(words));
// moon – new – why
```
