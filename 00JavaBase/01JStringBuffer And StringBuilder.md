# StringBuffer

线程安全,效率没有StringBuilder高

``` java
    @Override
    public synchronized StringBuffer append(String str) {
        toStringCache = null;
        super.append(str);
        return this;
    }
```

有synchronized标记的同步方法

# StringBuilder

效率相对较高,但是它非线程安全

``` java
    @Override
    public StringBuilder append(String str) {
        super.append(str);
        return this;
    }
```

无synchronized标记