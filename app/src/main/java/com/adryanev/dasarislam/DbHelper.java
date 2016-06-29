package com.adryanev.dasarislam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by AdryanEV on 25/06/2016.
 */
public class DbHelper extends SQLiteOpenHelper {


    ArrayList<Data> rukunIman, rukunIslam, namaNabi, namaMalaikat;
    //database version
    private static final int DATABASE_VERSION = 1;

    //database Name
    private static final String DATABASE_NAME = "dasarIslam";

    //table Name
    private static final String TABLE_RUKUNIMAN = "rukunIman";
    private static final String TABLE_RUKUNISLAM = "rukunIslam";
    private static final String TABLE_NAMAMALAIKAT = "namaMalaikat";
    private static final String TABLE_NAMANABI = "namaNabi";

    //column name
    private static final String KEY_ID = "id";
    private static final String KEY_RUKUN = "rukun";
    private static final String KEY_NAMA = "nama";
    private static final String KEY_PENJELASAN = "penjelasan";
    private static final String KEY_TUGAS = "tugas";
    private static final String KEY_MUKJIZAT = "mukjizat";
    //create table statement
    private static final String CREATE_TABLE_RUKUN_IMAN = "CREATE TABLE " + TABLE_RUKUNIMAN + " (" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_RUKUN + " TEXT," + KEY_PENJELASAN + " TEXT )";
    private static final String CREATE_TABLE_RUKUN_ISLAM = "CREATE TABLE " + TABLE_RUKUNISLAM + " (" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_RUKUN + " TEXT," + KEY_PENJELASAN + " TEXT )";
    private static final String CREATE_TABLE_NAMA_MALAIKAT = "CREATE TABLE " + TABLE_NAMAMALAIKAT + " (" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAMA + " TEXT, " + KEY_TUGAS + " TEXT )";
    private static final String CREATE_TABLE_NAMA_NABI = "CREATE TABLE " + TABLE_NAMANABI + " (" + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_NAMA + " TEXT, " + KEY_MUKJIZAT + " TEXT )";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_RUKUN_IMAN);
        db.execSQL(CREATE_TABLE_RUKUN_ISLAM);
        db.execSQL(CREATE_TABLE_NAMA_NABI);
        db.execSQL(CREATE_TABLE_NAMA_MALAIKAT);
        insertRukunIman(db, 1, "1. Iman Kepada Allah", "\t\tRukun Iman  mempunyai enam  pilar dan yang pertama adalah iman / mempercayai Allah SWT,  tuhan sang  pencipta alam itu ada serta menyakini bahwa  tiada tuhan selain Allah  karena orang yg beriman, percaya dan menyembah kepada Allah akan mendapatkan ketenangan dan ketentraman jiwa yg muncul dari hati secara ikhlas.");
        insertRukunIman(db, 2, "2. Iman Kepada Malaikat Allah", "\t\tMengimani adanya  malaikat,  kita wajib untuk membenarkan bahwa para malaikat tersebut memiliki wujudnya di mana Allah Swt telah menciptakan mereka dari cahayaNya. Mereka ialah makhluk dan hamba Allah yang senantiasa patuh dan beribadah selalu kepadaNya.");
        insertRukunIman(db, 3, "3. Iman Kepada Kitab Allah", "\t\tMengimani Kitab Allah bahwa  mempunyai pengertian  bahwa kita sebagai seorang  Muslim  harus meyakini bahwa  Allah memiliki kitab  – kitab yg di turunkan kepada Nabi dan Rosul (Sebelum Al-qur’an) yang benar – benar merupakan kalam / FirmanNya dan ia (Kitabnya) adalah cahaya dan petunjuk serta apa yang terkandung di dalamnya adalah suatu kebenaran.");
        insertRukunIman(db, 4, "4. Iman Kepada Rasul Allah", "\t\tMengimani Rukun Iman yang ke empat adalah menyakini adanya  para Rasul – Rasul atau Nabi utusan Allah yang diberi wahyu oleh Allah dan ditugaskan untuk menyampaikan pesan atau wahyu tersebut kepada hamba - hambanya untuk memberikan jalan yg lurus yang dibenarkan oleh Allah SWT.");
        insertRukunIman(db, 5, "5. Iman Kepada Hari Akhir", "\t\tMengimani semua yang terjadi di alam  barzakh (antara dunia dan akhirat) berupa fitnah kubur (nikmat kubur atau siksa kubur). Mengimani tanda-tanda hari kiamat. Mengimani hari kebangkitan di padang mahsyar hingga berakhir di Surga atau Neraka.");
        insertRukunIman(db, 6, "6. Iman Kepada Takdir Baik dan Buruk", "\t\tMengimani kejadian yang baik maupun yang buruk, semua itu berasal dari Allah Ta’ala. Karena seluruh makhluk tanpa terkecuali, zat dan sifat mereka begitupula perbuatan mereka adalah ciptaan Allah.");

        insertRukunIslam(db, 1, "1. Syahadat", "\t\tRukun Islam yang pertama kali wajib di lakukan bagi seorang yang masuk agama Islam yaitu mengucapkan 2 kalimat Syahadat yang memiliki pengertian : \" Meyakinkan tak ada tuhan yang terkecuali di sembah di dunia ini kecuali Allah SWT dan Sesungguhnya Nabi Muhammad Saw adalah utusan Allah.\"");
        insertRukunIslam(db, 2, "2. Shalat", "\t\tRukun Islam ke-Dua yang mesti kita lakukan yakni mendirikan / menunaikan Shalat, adapun jenis Shalat yang mesti / wajib dilakukan oleh seseorang muslim ialah 5 Shalat Wajib yang antara lain Shalat Subuh, Shalat Dhuhur, Shalat Asyar, Shalat Maghrib & Shalat Isya.");
        insertRukunIslam(db, 3, "3. Zakat", "\t\tMemberikan 2,5% dari uang simpanan kepada orang miskin atau yang membutuhkan, orang yang wajib menerima zakat antara lain Fakir, Miskin, Amil, Muallaf, Riqob, Qhorim, Sbilillah, Ibnu Sabil.");
        insertRukunIslam(db, 4, "4. Puasa", "\t\tBerpuasa pada bulan Ramadhan yakni menahan diri dari  makan dan minum serta segala perbuatan yang bisa /  membatalkan puasa,  mulai dari terbit  fajar  hinggalah terbenam matahari, untuk meningkatkan ketakwaan seorang Muslim.");
        insertRukunIslam(db, 5, "5. Haji", "\t\tPergi beribadah ke Mekkah, setidaknya sekali seumur hidup bagi mereka yang mampu, maksudnya yang sanggup baik material, fisik ataupun ilmu dengan berkunjung dan menjalankan Ibadah haji.");

        insertNamaMalaikat(db, 1, "1. Malaikat Jibril", "\t\tMalaikat Jibril mempunyai tugas yaitu menyampaikan wahyu yang diberikan oleh Allah SWT, kepada Nabi dan Rasul. Terdapat ayat yang menjelaskannya di Al-Qur’an surat Al-Baqarah ayat 97.");
        insertNamaMalaikat(db, 2, "2. Malaikat Mikail", "\t\tSaat  mahluk hidup mendapat rizki dalam hidup anda berupa apa saja, bisa harta, kesehatan atau apapun. Ketahuilah bahwa malaikat Mikail lah yang membagikan rizki tersebut. Ya, malaikat Mikail tugasnya adalah membagikan rizki.");
        insertNamaMalaikat(db, 3, "3. Malaikat Isrofil", "\t\tDalam rukun iman yang terakhir atau yang keenam  kita umat manusia khususnya umat muslim wajib  beriman pada hari kiamat. Ketahuilah  bahwa pada hari kiamat  nanti akan ada malaikat yang bertugas khusus untuk meniup terompet Sangkakala, pertanda bahwa berakhir sudah kehidupan di dunia.");
        insertNamaMalaikat(db, 4, "4. Malaikat Izroil", "\t\tAllah telah berfirman dalam Al-Qur’an pada surat Ali Imran ayat 185 yang berbunyi “setiap yang bernyawa pasti akan mengalami mati”. Ketahuilah, bahwa malaikai Izrail lah yang bertugas untuk mencabut nyawa.");
        insertNamaMalaikat(db, 5, "5. Malaikat Munkar", "\t\tKetika kita sudah  mati dan berada dalam kubur,  ada  malaikat yang akan menanyakan amal perbuatan kita semasa berada  hidup  dan akan menyiksa kita ketika kita tidak bisa menjawab pertnyaan, yakni malaikat Munkar yang bertugas menanyakan amal perbuatan manusia di alam kubur.");
        insertNamaMalaikat(db, 6, "6. Malaikat Nakir", "\t\tAdalah malaikat Nakir yang mempunyai tugas yang sama dengan malaikat Munkar,  malaikat  Munkar dan  Nakir mempunyai tugas yang sama di alam kubur yaitu menanyakan amal perbuatan manusia di alam kubur.");
        insertNamaMalaikat(db, 7, "7. Malaikat Raqib", "\t\tManusia di dunia ini pasti  pernah melakukan  sesuatu  yang baik  maupun buruk, terlepas dia sengaja atau  tidak. Ketahuilah bahwa ada malaikat yang bertugas mencatat semua amal perbuatan kita yang baik semasa kita hidup di dunia ini. Dia adalah malaikat Raqib, sang pencatat amal baik.");
        insertNamaMalaikat(db, 8, "8. Malaikat Atid", "\t\tJika kita tadi  membahas malaikat Raqib  yang tugasnya mencatat amal baik manusia  pada semasa hidupnya. Lain dengan malaikat Atid, malaikat Atid mempunyai tugas kebalikan dari malaikat Raqib yaitu mencatat seluruh amal buruk perbuatan manusia sema hidup didunia.");
        insertNamaMalaikat(db, 9, "9. Malaikat Malik", "\t\tPercayalah bahwa kita semua tidak akan mau menyinggahi tempat yang satu ini, tempat diciptakan untuk orang yang kufur kepada Allah SWT, orang - orang yang tidak berada di jalanNya dan tidak pernah patuh kepada perintahNya, tempat tersebut adalah neraka. Dan malaikat yang bertugas menjaga pintu neraka adalah malaikat Malik.");
        insertNamaMalaikat(db, 10, "10. Malaikat Ridwan", "\t\tBerbeda dengan yang diatas, jika kita orang yang selalu amanah dijalan Allah SWT, orang yang yang selalu taat pada perintahNya, layak dan dapat di singgah di surga nya Allah SWT.  Ketahuilah, bahwa di sana ada malaikat  Ridwan  sang penjaga pintu surga.");


        insertNamaNabi(db, 1, "1. Nabi Adam AS", "\t\tManusia pertama yang dijadikan oleh Allah  secara langsung dan  menyuruh agar para  malaikat tunduk kepadanya. Allah mengajarinya, nama - nama berbagai benda, dan menciptakan istrinya dan  menempatkannya di dalam surga dan serta memperingatkan  kepada  mereka agar tidak  mendekati  sebuah  pohon  tertentu. Akan  tetapi setan menggoda mereka  hingga  mereka  memakan buah pohon itu. Allah menurunkan mereka ke bumi Ia di jadikan  khalifah Allah di muka bumi dan juga sebagai rasul kepada anak-anaknya. Dia adalah nabi pertama di atas bumi.");
        insertNamaNabi(db, 2, "2. Nabi Idris AS", "\t\tNabi Idris diyakini Nabi pertama yang menulis dengan pena, Masyarakat terdahulu mempercayai pula bahwa ia dibawa ke surga tanpa mengalami kematian. Peristiwa itu terjadi ketika beliau berusia 82 tahun");
        insertNamaNabi(db, 3, "3. Nabi Nuh AS", "\t\tNabi Nuh menyebarkan ajaran Islam untuk menyembah Allah, namun masyarakat menolak menganggapnya gila. Nabi Nuh kemudian  diberikan  peringatan oleh Allah SWT bahwa akan ada banjir besar yang akan melanda pada daerahnya. Nabi Nuh diperintahkan membuat sebuah kapal, Namun masyarakat sekitar tetap tidak mendengarkan peringatan yang disampaikan oleh Nabi Nuh, sehingga mereka semua hanyut dalam banjir tersebut.");
        insertNamaNabi(db, 4, "4. Nabi Hud AS", "\t\tNabi Hud tergolong dalam kaum ada yang terhormat, kehidupan mereka serba maju dan berkecukupan. Namun sayangnya mereka selalu berfoya-foya dan tenggelam dalam kehidupan Fana.");
        insertNamaNabi(db, 5, "5. Nabi Shalih AS", "\t\tMukjizat Nabi Shalih yang paling terkenal adalah Unta betina yang keluar dari batu, setelah Nabi Shalih memukulkan Telapak Tangannya. namun kaum yang tidak menyukainya berusaha untuk membunuh Unta tersebut,dan pada akhirnya mereka dijatuhi Azab Petir dan Gempa.");
        insertNamaNabi(db, 6, "6. Nabi Ibrahim AS", "\t\tIbrahim-lah  yang membangun Ka'bah dikota Mekkah, keyakinannya yang kuat terhadap Islam dimulai percaya dari pencariannya akan Tuhan.Dia sangat lah tidak menerima orang-orang disekitarnya yang menyembah berhala, sampai akhirnya Nabi Ibrahim dibakar hidup-hidup. namun Allah SWT menurunkan Mukjizatnya dengan menyelamatkan Nabi Ibrahim.");
        insertNamaNabi(db, 7, "7. Nabi Luth AS", "\t\tKetika Nabi Luth hampir merasa putus  asa, dia  berdoa kepada  Allah  agar  diselamatkan b ersama  pengikutnya serta membinasakan orang-orang yang berbuat kerusakan. Kemudian datanglah malaikat menyelamatkan Nabi Luth beserta pengikutnya dan menghancurkan yang lainnya dengan batu-batuan.");
        insertNamaNabi(db, 8, "8. Nabi Ismail AS", "\t\tSuatu saat Nabi Ismail haus dan ibunya bolak-balik dari bukit Safa-Marwah mencari air, hingga akhirnya keluar        mata air zamzam. Dalam perjalanan  menuju  tempat  penyembelihan, Nabi Ismail digoda oleh Syaitan agar dapat membatalakan niatnya. Namun Nabi Ismail tidak goyah dan melempar syaitan tersebut dengan batu. yang saat ini menjadi ritula ibadah haji, yaitu lempar  jumrah. Seperti  yang kita ketahui, saat akan disembelih jasad Nabi Ismail digantikan oleh seekor kambing, yang akhirnya menjadi cikal bakal ibadah Idul Adha");
        insertNamaNabi(db, 9, "9. Nabi Ishaq AS", "\t\tNabi Ishaq banyak menemani bapaknya yaitu Nabi Ibrahim dalam berdakwah menyebarkan ajaran Islam. Nabi Ishak sebagai “seorang anak yang arif dan bijaksana.");
        insertNamaNabi(db, 10, "10. Nabi Yaqub AS", "\t\tNabi Ya''qub adalah kakek moyang para rasul sebelum masa Nabi Muhammad. Sikap  cara berpikirnya sangatlah berpengaruh kepada para rasul keturunannya, serta kaum Yahudi dan kemudian Nasrani penegak panji keesaan Allah sebelum era Nabi Muhammad SAW");
        insertNamaNabi(db, 11, "11. Nabi Yusuf AS", "\t\tNabi Yusuf dikisahkan dalam riwayatnya sebagai seorang  pria yang  sangat tampan dan sangat piawai melakukan kemimpin negaranya. Sejak kecil dia mendapat mimpi yang tidak biasa dan ketika besar dia dapat dapat mentakwilkan mimpinya tersebut, sehingga dia sangat dihormati oleh masyarakat sekitarnya");
        insertNamaNabi(db, 12, "12. Nabi Ayub AS", "\t\tNabi Ayub Adalah orang kaya, Allah pun menentang iblis sekiranya dia dapat meruntuhkan iman Nabi Ayub. Ujian pun tiba, seluruh harta kekayaan yang dimiliki Nabi Ayub habis terbakar, setelah itu Nabi Ayub terserang penyakit kulit hingga 80 tahun lamanya. Namun dia dan istrinya yang setia, Rahmah, tetap bertawakal kapada Allah SWT. Sampai akhirnya Allah berfirman agar Nabi Ayub menapakkan kakinya ditanah.kemudian dari tanah tersebut akan keluar air yang dapat menyembuhkan penyakit yang dideritanya selama 80 tahun");
        insertNamaNabi(db, 13, "13. Nabi Syuaib AS", "\t\tNabi Syuaib menyebarkan ajaran Islam di daerah Madyan, namun masyarakat Madyan menolak ajaran tersebut hingga akhirnya Allah menurunkan azab berupa petir dan kilat yang menghanguskan mereka");
        insertNamaNabi(db, 14, "14. Nabi Musa AS", "\t\tMaka Musa menjatuhkan tongkat-nya, lalu seketika itu juga tongkat itu menjadi ular yang sebenarnya, Lalu Kami  wahyukan kepada Musa: \"Pukullah lautan itu dengan tongkatmu.\" Maka terbelahlah lautan itu dan tiap-tiap belahan adalah seperti gunung yang besar");
        insertNamaNabi(db, 15, "15. Nabi Harun AS", "\t\tNabi Harun disebut sebagai partner Nabi Musa. Dia adalah sosok yang cakap berdakwah, pandai berdiplomasi, penuh perhatian. Nabi Harun selalu mendampingi Nabi Musa dalam berdakwah, hingga suatu saat dia Nabi Musa memutuskan untuk beruzlah dan menitipkan pembinaan umatnya kepada Nabi Harun");
        insertNamaNabi(db, 16, "16. Nabi Dzulkifli AS", "\t\tSejarah menyebutkan bahwa Nabi Dzulkifli adalah putra Nabi Ayub. Dikisahkan pula bahwa dia mewarisi sifat sabar ayahnya. Suatu saat beliau ditunjuk menjadi seorang raja setelah dapat memenuhi persyaratan yang diminta");
        insertNamaNabi(db, 17, "17. Nabi Daud AS", "\t\tFigur Nabi Daud memuncak saat berhasil membunuh jalut, pemimpin kaum pemberontak palestina. Nabi Daud kemudian menjadi seorang raja dan berlaku sangat adil. Di masa kerajaan Nabi Daud tumbuh kuat dan masyarakat menjadi makmur. Suatu saat Nabi Daud melarang para nelayan untuk tidak melaut di hari sabtu, namun peringatan tersebut dilanggar, sehingga terjadi bencana gempa yang menewaskan seluruh penduduk");
        insertNamaNabi(db, 18, "18. Nabi Sulaiman AS", "\t\tSalah satu keahlian Nabi Sulaiman yang paling menonjol adalah kemampuannya berkomunikasi dengan binatang. Dia juga merupakan raja yang sangat bijaksana, kekuasaannya bahkan mencakup bangsa jin");
        insertNamaNabi(db, 19, "19. Nabi Ilyas AS", "\t\tNabi Ilyas tinggal di lembah sungai Yordan dimana penduduknya menyembah berhala, Nabi Ilyas menyuruh kepada mereka semua untuk meninggalkan berhala, namun mereka tidak mengindahkannya. Bahkan menantang agar Tuhan yang disembah Nabi Ilyas menurunkan bencana, dan akhirnya kekeringan melanda daerah tersebut. Setelah beberapa tahun, Nabi Ilyas dapat meyakinkan kaum tersebut untuk menyembah Allah SWT");
        insertNamaNabi(db, 20, "20. Nabi Ilyasa AS", "\t\tNabi Ilyasa merupakan kerabat dekat Nabi Ilyas. Setelah Nabi Ilyas meninggal, beliau melanjutkan perjuangan Nabi Ilyas untuk menghalau penyembahan berhala yang kembali merebak di lembah sungai Yordan. Namun kaum tersebut tidak mau mendengarkan sehingga terjadi bencana kekeringan kembali melanda mereka");
        insertNamaNabi(db, 21, "21. Nabi Yunus AS", "\t\tNabi yunus berusaha menyebarkan ajaran Allah, namun ia tidak mendapat sambutan baik dari masyarakat. Dalam perjalanannya menjauhi daerah tersebut karena khawatir akan dibunuh, kapal yang ia tumpangi diguncang topan dan diputuskan bahwa Nabi Yunus akan dikorbankan untuk ditenggelamkan ke laut demi keselamatan penumpang lainnya. Namun mukjizat Allah tiba, Nabi Yunus dimakan oleh seekor ikan yang kemungkinan adalah ikan paus, dan ditemukan masih hidup didalam perut ikan paus tersebut");
        insertNamaNabi(db, 22, "22. Nabi Zakaria AS", "\t\tNabi Zakaria dan istrinya, Isya, membaktikan diri  untuk menjaga  Baitul Maqdis - Rumah Ibadah peninggalan Nabi Sulaiman di Yerusalem. Nabi Zakaria dikaruniai keturunan oleh Allah SWT di saat usianya sudah cukup uzur, yaitu sekitar 100 tahun, anak tersebut adalah Nabi Yahya");
        insertNamaNabi(db, 23, "23. Nabi Yunus AS", "\t\tNabi Yahya mengajarkan bahwa kebenaran harus ditegakkan dengan resiko apapun. Pada riwayatnya dicontohkan saat ia bersikeras melarang pernikahan antara seorang paman dengan keponakannya sendiri");
        insertNamaNabi(db, 24, "24. Nabi Isa AS", "\t\tNabi Isa adalah putra dari Bunda Maryam yang dilahirkan tanpa memiliki suami, Hal ini menimbulkan kontroversi dan hujatan bertubi-tubi kepada Maryam. Secara ajaib Nabi Isa yang saat itu masih bayi tiba-tiba berbicara dan menjelaskan apa yang sebenarnya terjadi. Bahwa penciptaan dirinya diawalai dari kedatangan malaikat jibril kepada ibunya. Nabi Isa juga memperlihatkan banyak mukjizat lainnya ketika ia tumbuh dewasa, diantaranya membentuk seekor burung hidup dari sebuah tanah liat, menghidupkan orang mati, menyembuhkan kebutaan dan mendatangkan makanan yang semula tidak ada dan menjadi ada. Penyelamatan Nabi Isa dari penyaliban juga merupakan salah satu bentuk mukjizat yang diberikan oleh Allah SWT");
        insertNamaNabi(db, 25, "25. Nabi Muhammad SAW", "\t\tNabi Muhammad SAW adalah Rasul terakhir, sekaligus sebagai penutup para Rasul-Rasul sebelumnya. Dia lah yang menyempurnakan ajaran-ajaran Islam.Mukjizat yang diturunkan Allah kepadanya sangatlah banyak, salah satunya yang paling besar adalah Al-Qur''an, yang menjadi pedoman utama kehidupan manusia. Selain ada pula peristiwa Isra Mi''raj yang membawanya bertemu dengan Allah SWT");
    }

    private void insertRukunIman(SQLiteDatabase db, int id, String nama, String penjelasan) {
        ContentValues values = new ContentValues();
        values.put(KEY_ID, id);
        values.put(KEY_RUKUN, nama);
        values.put(KEY_PENJELASAN, penjelasan);
        db.insert(TABLE_RUKUNIMAN, null, values);

    }

    private void insertRukunIslam(SQLiteDatabase db, int id, String nama, String penjelasan) {
        ContentValues values = new ContentValues();
        values.put(KEY_ID, id);
        values.put(KEY_RUKUN, nama);
        values.put(KEY_PENJELASAN, penjelasan);
        db.insert(TABLE_RUKUNISLAM, null, values);

    }

    private void insertNamaNabi(SQLiteDatabase db, int id, String nama, String penjelasan) {
        ContentValues values = new ContentValues();
        values.put(KEY_ID, id);
        values.put(KEY_NAMA, nama);
        values.put(KEY_MUKJIZAT, penjelasan);
        db.insert(TABLE_NAMANABI, null, values);


    }

    private void insertNamaMalaikat(SQLiteDatabase db, int id, String nama, String penjelasan) {
        ContentValues values = new ContentValues();
        values.put(KEY_ID, id);
        values.put(KEY_NAMA, nama);
        values.put(KEY_TUGAS, penjelasan);
        db.insert(TABLE_NAMAMALAIKAT, null, values);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
