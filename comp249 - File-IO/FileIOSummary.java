/* 
Java File I/O — Basic Methods Summary
--------------------------------

FileReader (TEXT reading)

Methods:
read()      // reads ONE character at a time and returns its numeric code (Unicode/ASCII) as an int
close()     

FileWriter (TEXT writing)
Methods:
write(String)
write(char)
flush()
close()


BufferedReader (TEXT reading with buffering)
Methods:
readLine()  // reads an entire line until newline '\n'
read()      // reads ONE character at a time
close()


BufferedWriter (TEXT writing with buffering)
Methods:
write(String)
newLine()
flush()
close()


Scanner (TEXT reading, formatted input)
Methods:
next()      // reads text until SPACE or newline
nextLine()  // reads the entire line
nextInt()   // reads an integer
nextDouble()
hasNext()


PrintWriter (TEXT writing, easy printing)
Methods:
print()
println()
printf()
close()


FileInputStream (BINARY reading)
Methods:
read()      // reads ONE byte
close()


FileOutputStream (BINARY writing)
Methods:
write(int)  // writes ONE byte
close()


ObjectInputStream (OBJECT / binary reading)
Methods:
readObject()
readInt()
readDouble()
close()


ObjectOutputStream (OBJECT / binary writing)
Methods:
writeObject()
writeInt()
writeDouble()
close()



Simple rule
--------------------------------

TEXT files (characters)

Reading:
FileReader
BufferedReader
Scanner

Writing:
FileWriter
BufferedWriter
PrintWriter


BINARY files (bytes)

Reading:
FileInputStream

Writing:
FileOutputStream


OBJECTS (serialization)

Reading:
ObjectInputStream

Writing:
ObjectOutputStream
*/