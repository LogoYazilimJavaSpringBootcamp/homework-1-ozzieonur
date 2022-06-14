# Homework-1
````
1. Java platform bağımsızlığını nasıl sağlar ?
````

   Cevap:
   Java derlendiğinde diğer dillerin aksine 0 ve 1 bit değerlerinden oluşan makiene diline çevrilmez.
   Java'nın kaynak kodları yalnızca Java Sanal Makine'sinin (JVM) anlayabileceği bitkodlarına derlenir.
   Bu bitkodlar işlemci seçmez. Bu sayede Java platform bağımsızlığını sağlar.
<br><br>

````   
2. Java neden çoklu kalıtımı desteklemez? Hangi diller bu duruma neden izin verir?
````
   Cevap: Aslında tam olarak Java çoklu kalıtımı desteklemez diyemeyiz. Java çoklu kalıtımı (tanımına uygun şekilde) classlar üzerinden desteklemez.
   Çünkü çoklu kalıtım ortaya karmaşık ve anlaşılması zor kalıtım ağaçları çıkartabilir ve SOLID'in ilk kuralı olan Single Responsibility prensibini ihlal edebilir.
   Java en güçlü yanlarından biri olan az karmaşıklık ve basit dil ilkelerine uymayan çoklu kalıtım özelliğini aslında ilkelere uyacak şekilde Interface'ler üzerinden sağlar.
   Tabi bu duruma "Kalıtım" demek ne derece doğru orası tartışılır.
   Çoklu kalıtımda en sık karşılaşılan problem olan Diamond Problem'in çalışma zamanı hatasını engelleyecek çeşitli çözümler getirmiş olan C++,Python gibi diller Çoklu Kalıtımı destekler.
   Ancak bu dillerde de bu özelliği çok sık kullanmak tavsiye edilmiyor.
````   
3. Build Tool nedir? Java ekosistemindeki toollar neler?
````
Cevap: Build tool'u, bir yazılım yapısının oluşturulmasını sağlayan, bağımlılıkları yöneten, gerekli kütüphane ve paketlere erişimi kolaylaştıran ve kaynak kodtan yürütülebilir uygulamaların derlenmesini sağlayan bir araç olarak nitelendirebiliriz.
Java'nın ekosisteminde Gradle, Ant ve Maven gibi build toollar yer alır.

````
4. Collection framework içerisindeki yapılar
````
Java Collection framework öğelerimizi topluluk halinde tutan dizi yapısının gelişmiş hali gibi düşünülebilir.
Bu yapılar dizilerde sıralama, dizi içerisinde arama yapma, diziyi ekrana yazdırma gibi uygulamak istediğimiz bir çok methodu hazır halde
bize interface ve interfacelerden oluşan kurgular üzerinden sunuyor. <br> <br>
``1) Set<E> : ``
Küme mantığıyla çalışır ve sıralama garantisi vermez. Aynı elemanların küme içerisinde olmasına izin vermez.
Bu sayede içerisinde benzersiz veriler barındırır. HashSet , LinkedHashSet ve TreeSet bu interface üzerinden kurgulanır  <br> <br>
`● HashSet<E> :` Hafızadaki kayıtları hashlerle sırasız şekilde tutuyor. null değeri de tutulabilir. <br>
Örnekleyelim:
````
HashSet<String> hayvanlar = new HashSet<String>();

hayvanlar.add("Kedi");
hayvanlar.add("Köpek");
hayvanlar.add("Kuş");

// Aynı elementten birtane daha eklemeyi deneyelim
hayvanlar.add("Kedi"); 

//null değer eklemeye çalışalım.
hayvanlar.add(null);


hayvanlar.forEach(hayvan -> System.out.print(hayvan + " "));
````

Kod çıktısı:
``null Kuş Köpek Kedi``



``● LinkedHashSet<E> :`` HashSet yapısıyla çok benzer yapıdadır. Tek farkı eklediğimiz elementler ekleme sırasına göre tutulur. <br>
Örnekleyelim:
````
LinkedHashSet<String> hayvanlar = new LinkedHashSet<String>();

hayvanlar.add("Kedi");
hayvanlar.add("Köpek");
hayvanlar.add("Kuş");

// Aynı elementten birtane daha eklemeyi deneyelim
hayvanlar.add("Kedi"); 

//null değer eklemeye çalışalım.
hayvanlar.add(null);


hayvanlar.forEach(hayvan -> System.out.print(hayvan + " "));
````
Bu sefer ekleğimiz sıraya göre bir çıktı alacağız:
```Kedi Köpek Kuş null ```

``● TreeSet<E> :`` İsminden de anlaşılacağı üzere ağaç yapısı gibi düşünebiliriz. Elementler artan sıralamayla yani asceding order mantığıyla tutuluyor. Null değerini bu yapıya ekleyemiyoruz.  <br>

Bu sefer anlayabilmek adına Integer değerler üzerinden işlem yapalım:
````
TreeSet<Integer> sayilar = new TreeSet<Integer>();

sayilar.add(5);
sayilar.add(15);
sayilar.add(10);

// Aynı elementten birtane daha eklemeyi deneyelim
sayilar.add(5); 

// Null atamaya çalıştığımızda NullPointerException hatası alacağımız yorum satırına alıyorum.
// sayilar.add(null);

sayilar.forEach(hayvan -> System.out.print(hayvan + " "));
````
```Çıktı şu şekilde: 5 10 15  ```

``2) List<E> :`` List yapısı array yapısına çok benzer bir yapıda. Set'in aksine tekrarlı element eklememize izin verir, elementleri sıralı şekilde tutar ve istediğimiz index'e elementleri ekleyebilmemizi sağlar.
ArrayList, LinkedList ve Vector gibi yapılar bu Interface üzerinden sağlanır.

``● ArrayList<E> :`` Collectionslardan en çok kullandığımız yapıdır. List özelliklerinin hepsini barındırır.<br>
Örnekleyelim: 
````
ArrayList<String> icecekler = new ArrayList<String>();

icecekler.add("Kola");
icecekler.add("Fanta");
icecekler.add("MeyveSuyu");
// Aynı elementten birtane daha eklemeyi deneyelim
icecekler.add("Kola");

icecekler.forEach(icecek -> System.out.print(icecek + " "));
````
Çıktımız:
``Kola Fanta MeyveSuyu Kola``

``● LinkedList<E> :`` Sonuçlarını incelediğimizde ArrayList ile aynıdır. Ancak fonksiyonlara göre notasyonları değişmekte. Arama işlemlerinde ArrayList kullanımı daha avantajlıdır. Ekeleme Çıkarma işlemlerimiz çok ise LinkedList kullanmamız daha doğru olur.  <br>

``● Vector<E> :`` Çok sık kullanılan bir apı değildir. Senkronize bir yapıdadır ve varsayılan kapasitesi 10'dur. Daha fazla eleman eklemek istediğimizde otomatik olarak kapasite 20ye yükselir ancak kapasiteyi ve artış değerini kullanıcı belirleyebilir. <br>

``3) Queue<E> :`` Fifo prensibiyle çalışır, yani ilk giren element ilk çıkar. Kuyruk mantığıyla çalışır. Bellekteki yerinin önemi yoktur. Çıktısı Fifo'ya uygun şekilde sıralı gelir. <br>

``4) Map<K,V> : `` Kısaca eşleme tabloları diyebiliriz. Key, Value olmak üzere 2 değerli bir liste tutar. Her Key değerine bir Value değeri eşlenir. Tuttuğu adresi kendi belirler. HashMap, TreeMap, HashTable gibi yapılar bu Interface üzerinden tanımlanır. <br>

``● HashMap<K, V> :`` Null key değeri ve Null value değeri kabul eder. Sıralama garantisi vermez. <br>
Örnekleyelim: 
````
HashMap<Integer, String> musteriler = new HashMap<Integer, String>();
        musteriler.put(1, "Onur");
        musteriler.put(2, "Ufuk");
        musteriler.put(3, "Ümit");
        

        musteriler.forEach((musteriId, musteriName) -> System.out.print(musteriId + "-" +musteriName + " | "));
````
Çıktıda da göreceğimiz gibi her müşteri id'sine karşılık müşteri ismini bize getiriyor: <br>
``1-Onur | 2-Ufuk | 3-Ümit | 4-Hüseyin | ``

``● TreeMap<K, V> :``Yine isimden de anlaşılacağı gibi ağaç yapısına benzer. HashMap yapısından tek farkı, elementleri artan sıralama (ascending) ile tutmasıdır. <br>
Örnekleyelim: 
````
TreeMap<Integer, String> musteriler = new TreeMap<>();
        musteriler.put(1, "Onur");
        musteriler.put(7, "Ufuk");
        musteriler.put(6, "Hüseyin");
        musteriler.put(3, "Ümit");


        musteriler.forEach((musteriId, musteriName) -> System.out.print(musteriId + "-" +musteriName + " | "));
````
Çıktı: `` 1-Onur | 3-Ümit | 6-Hüseyin | 7-Ufuk | ``


``● HashTable<K, V> :`` HashMap ile benzer bir yapıya sahip ancak farklar mevcuttur. HashTable senkronize yapıdadır, dolayısıyla performansı düşüktür. HashMap null değer alırken HashTable alamaz.
