# PrintStream

java.lang.Object
  继承者 java.io.OutputStream
      继承者 java.io.FilterOutputStream
          继承者 java.io.PrintStream

PrintStream 为其他输出流添加了功能，使它们能够方便地打印各种数据值表示形式。它还提供其他两项功能。与其他输出流不同，PrintStream 永远不会抛出 IOException；而是，异常情况仅设置可通过 checkError 方法测试的内部标志。另外，为了自动刷新，可以创建一个 PrintStream；这意味着可在写入 byte 数组之后自动调用 flush 方法，可调用其中一个 println 方法，或写入一个换行符或字节 ('\n')。 

PrintStream 打印的所有字符都使用平台的默认字符编码转换为字节。在需要写入字符而不是写入字节的情况下，应该使用 PrintWriter 类。 


System.out.println(); 中的out也是PrintStream()


# BufferedOutputStream

java.lang.Object
  继承者 java.io.OutputStream
      继承者 java.io.FilterOutputStream
          继承者 java.io.BufferedOutputStream


该类实现缓冲的输出流。通过设置这种输出流，应用程序就可以将各个字节写入底层输出流中，而不必针对每次字节写入调用底层系统。 