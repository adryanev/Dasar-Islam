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
        insertRukunIman(db, 1, "Iman Kepada Allah", "Rukun Iman itu mempunyai 6 (enam) pilar dan yang pertama adalah iman / mempercayai Allah SWT tuhan sang pencipta alam itu ada \nserta menyakini bahwa tiada tuhan selain Allah karena orang yg beriman, percaya dan menyembah kepada Allah akan mendapatkan ketenangan dan ketentraman jiwa yg muncul dari hati secara ikhlas.");
        insertRukunIman(db, 2, "Iman Kepada Malaikat Allah", "Mengimani adanya malaikat, kita wajib untuk membenarkan bahwa para malaikat tersebut memiliki wujudnya di mana Allah Swt \ntelah menciptakan mereka dari cahayaNya. Mereka ialah makhluk dan hamba Allah yang senantiasa patuh dan beribadah selalu kepadaNya.");
        insertRukunIman(db, 3, "Iman Kepada Kitab Allah", "Mengimani Kitab Allah bahwa mempunyai pengertian bahwa kita sebagai seorang Muslim harus meyakini bahwa Allah \nmemiliki kitab – kitab yg diturunkan kepada Nabi dan Rosul (Sebelum Al-qur’an) yang benar – benar merupakan kalam / FirmanNya dan ia (Kitabnya) adalah cahaya dan petunjuk serta apa yang terkandung di dalamnya adalah suatu kebenaran.");
        insertRukunIman(db, 4, "Iman Kepada Rasul Allah", "Mengimani Rukun Iman yg ke empat adalah menyakini adanya para Rasul – Rasul atau Nabi utusan Allah yang diberi wahyu oleh Allah \ndan ditugaskan untuk menyampaikan pesan atau wahyu tersebut kepada hamba-hambanya untuk memberikan jalan yg lurus yang dibenarkan oleh Allah SWT.");
        insertRukunIman(db, 5, "Iman Kepada Hari Akhir", "Mengimani semua yang terjadi di alam barzakh (di antara dunia dan akhirat) berupa fitnah kubur (nikmat kubur atau siksa kubur). \nMengimani tanda-tanda hari kiamat. Mengimani hari kebangkitan di padang mahsyar hingga berakhir di Surga atau Neraka.");
        insertRukunIman(db, 6, "Iman Kepada Takdir Baik dan Buruk", "Mengimani kejadian yang baik maupun yang buruk, semua itu berasal dari Allah Ta’ala. Karena seluruh makhluk tanpa terkecuali, \nzat dan sifat mereka begitupula perbuatan mereka adalah ciptaan Allah.");

        insertRukunIslam(db, 1, "Syahadat", "Rukun Islam yang pertama kali wajib dilakukan bagi seorang yang masuk agama Islam yaitu mengucapkan 2 kalimat Syahadat yang memiliki pengertian : \n\" Meyakinkan tak ada tuhan yang terkecuali di sembah di dunia ini kecuali Allah SWT dan Sesungguhnya Nabi Muhammad Saw adalah utusan Allah.\"");
        insertRukunIslam(db, 2, "Shalat", "Rukun Islam ke-Dua yang mesti kita melakukan yakni mendirikan / menunaikan Shalat, adapun jenis Shalat yang mesti / wajib dilakukan oleh seseorang muslim ialah 5 Shalat Wajib yang antara lain \n Shalat Subuh, Shalat Dhuhur, Shalat Asyar, Shalat Maghrib & Shalat Isya.");
        insertRukunIslam(db, 3, "Zakat", "Memberikan 2,5% dari uang simpanan kepada orang miskin atau yang membutuhkan.");
        insertRukunIslam(db, 4, "Puasa", "Berpuasa dan mengendalikan diri selama bulan suci Ramadan.");
        insertRukunIslam(db, 5, "Haji", "Pergi beribadah ke Mekkah, setidaknya sekali seumur hidup bagi mereka yang mampu.");

        insertNamaMalaikat(db, 1, "Malaikat Jibril", "Menyampaikan wahyu dari Allah SWT.");
        insertNamaMalaikat(db, 2, "Malaikat Mikail", "Memberi rizki / rejeki pada manusia.");
        insertNamaMalaikat(db, 3, "Malaikat Isrofil", "Meniup sangkakala penanda hari kiamat telah tiba.");
        insertNamaMalaikat(db, 4, "Malaikat Izroil", "Mencabut nyawa.");
        insertNamaMalaikat(db, 5, "Malaikat Munkar", "Menanyakan dan melakukan pemeriksaan pada amal perbuatan manusia di alam kubur.");
        insertNamaMalaikat(db, 6, "Malaikat Nakir", "Menanyakan dan melakukan pemeriksaan pada amal perbuatan manusia di alam kubur bersama Malaikat Munkar.");
        insertNamaMalaikat(db, 7, "Malaikat Raqib", "Mencatat segala amal baik manusia ketika hidup.");
        insertNamaMalaikat(db, 8, "Malaikat Atid", "Mencatat segala perbuatan buruk / jahat manusia ketika hidup.");
        insertNamaMalaikat(db, 9, "Malaikat Malik", "Menjaga pintu neraka.");
        insertNamaMalaikat(db, 10, "Malaikat Ridwan", "Menjaga pintu Surga.");


        insertNamaNabi(db, 1, "Nabi Adam AS", "Nabi Adam diyakini sebagai manusia pertama yang menginjakkan kaki di bumi. Sebagai pasangan Nabi Adam adalah Hawa yang diciptakan dari tulang rusuk kiri Nabi Adam");
        insertNamaNabi(db, 2, "Nabi Idris AS", "Nabi Idris diyakini Nabi pertama yang menulis dengan pena, Masyarakat terdahulu mempercayai pula bahwa ia dibawa ke surga tanpa mengalami kematian. Peristiwa itu terjadi ketika beliau berusia 82 tahun");
        insertNamaNabi(db, 3, "Nabi Nuh AS", "Selamat dari Banjir besar dengan bantuan Kapal Besar yang telah diperingatkan oleh Allah Swt");
        insertNamaNabi(db, 4, "Nabi Hud AS", "Nabi Hud dan Pengikutnya selamat dari badai gurun selama 7 hari 7 malam");
        insertNamaNabi(db, 5, "Nabi Shalih AS", "Yang paling dikenal adalah unta betina yang keluar dari batu setelah ia memukulkan telapak tangannya");
        insertNamaNabi(db, 6, "Nabi Ibrahim AS", "Sempat dibakar hidup-hidup oleh Bangsa Kafir, Namun dia selamat dari kobaran api tersebut karena Allah Swt");
        insertNamaNabi(db, 7, "Nabi Luth AS", "Ketika Nabi Luth hampir merasa putus asa, dia berdoa kepada Allah agar diselamatkan bersama pengikutnya serta membinasakan orang-orang yang berbuat kerusakan. Kemudian datanglah malaikat menyelamatkan Nabi Luth beserta pengikutnya dan menghancurkan yang lainnya dengan batu-batuan.");
        insertNamaNabi(db, 8, "Nabi Ismail AS", "Suatu saat Nabi Ismail haus dan ibunya bolak-balik dari bukit Safa-Marwah untuk mencari air, hingga akhirnya keluar sebuah mata air zamzam.D alam perjalanan menuju tempat penyembelihan, Nabi Ismail digoda oleh Syaitan agar membatalakan niatnya. Namun Nabi Ismail tidak goyah dan melempar syaitan tersebut dengan batu. yang saat ini menjadi ritula ibadah haji, yaitu lempar jumrah. Seperti yang kita ketahui, saat akan disembelih jasad Nabi Ismail digantikan oleh seekor kambing, yang akhirnya menjadi cikal bakal ibadah Idul Adha");
        insertNamaNabi(db, 9, "Nabi Ishaq AS", "Nabi Ishaq banyak menemani bapaknya yaitu Nabi Ibrahim dalam berdakwah menyebarkan ajaran Islam. Nabi Ishak sebagai “seorang anak yang arif dan bijak");
        insertNamaNabi(db, 10, "Nabi Yaqub AS", "Nabi Ya''qub adalah kakek moyang para rasul sebelum masa Nabi Muhammad. Sikap dan cara berpikirnya tentu berpengaruh kepada para rasul keturunannya, serta kaum Yahudi dan kemudian Nasrani penegak panji keesaan Allah sebelum era Nabi Muhammad SAW");
        insertNamaNabi(db, 11, "Nabi Yusuf AS", "Nabi Yusuf dikisahkan dalam riwayatnya sebagai seorang pria yang sangat tampan dan sangat piawai dalam memimpin negaranya. Sejak kecia dia mendapat mimpi yang tidak biasa dan ketika besar dia dapat mentakwilkan mimpinya tersebut, sehingga dia sangat dihormati oleh masyarakat sekitarnya");
        insertNamaNabi(db, 12, "Nabi Ayub AS", "Nabi Ayub AS Adalah orang kaya, Allah pun menentang iblis sekiranya dia dapat meruntuhkan iman Nabi Ayub. Ujian itu pun tiba, seluruh harta kekayaan yang dimiliki Nabi Ayub habis terbakar, setelah itu Nabi Ayub terserang penyakit kulit hingga 80 tahun lamanya. Namun dia dan istrinya yang setia, Rahmah, tetap bertawakal kapada Allah SWT. Sampai akhirnya Allah berfirman agar Nabi Ayub menapakkan kakinya ditanah. kemudian dari tanah tersebut keluar air yang dapat menyembuhkan penyakit yang dideritanya selama 80 tahun");
        insertNamaNabi(db, 13, "Nabi Syuaib AS", "Nabi Syuaib menyebarkan ajaran Islam di daerah Madyan, namun masyarakat Madyan menolak ajaran tersebut hingga akhirnya Allah menurunkan azab berupa petir dan kilat yang menghanguskan mereka");
        insertNamaNabi(db, 14, "Nabi Musa AS", "Maka Musa menjatuhkan tongkat-nya, lalu seketika itu juga tongkat itu menjadi ular yang sebenarnya, Lalu Kami wahyukan kepada Musa: \"Pukullah lautan itu dengan tongkatmu.\" Maka terbelahlah lautan itu dan tiap-tiap belahan adalah seperti gunung yang besar");
        insertNamaNabi(db, 15, "Nabi Harun AS", "Nabi Harun disebut sebagai partner Nabi Musa. Dia adalah sosok yang cakap berdakwah, pandai berdiplomasi, dan penuh perhatian. Nabi Harun selalu mendampingi Nabi Musa dalam berdakwah, hingga suatu saat Nabi Musa memutuskan untuk beruzlah dan menitipkan pembinaan umatnya kepada Nabi Harun");
        insertNamaNabi(db, 16, "Nabi Dzulkifli AS", "Sejarah menyebutkan bahwa Nabi Dzulkifli adalah putra Nabi Ayub. Dikisahkan pula bahwa dia mewarisi sifat sabar ayahnya. Suatu saat beliau ditunjuk menjadi seorang raja setelah dapat memenuhi persyaratan yang diminta");
        insertNamaNabi(db, 17, "Nabi Daud AS", "Figur Nabi Daud memuncak saat dia berhasil membunuh jalut, pemimpin kaum pemberontak palestina. Nabi Daud kemudian menjadi seorang raja dan berlaku sangat adil. Di masa kerajaan Nabi Daud tumbuh kuat dan masyarakat menjadi makmur. Suatu saat Nabi Daud melarang para nelayan untuk tidak melaut di hari sabtu, namun peringatan tersebut dilanggar, sehingga terjadi bencana gempa yang menewaskan seluruh penduduk");
        insertNamaNabi(db, 18, "Nabi Sulaiman AS", "Salah satu keahlian Nabi Sulaiman yang paling menonjol adalah kemampuannya berkomunikasi dengan binatang. Dia juga merupakan raja yang sangat bijaksana, kekuasaannya bahkan mencakup bangsa jin");
        insertNamaNabi(db, 19, "Nabi Ilyas AS", "Nabi Ilyas tinggal di lembah sungai Yordan dimana penduduknya menyembah berhala, Nabi Ilyas menyuruh kepada mereka semua untuk meninggalkan berhala, namun mereka tidak mengindahkannya. Bahkan menantang agar Tuhan yang disembah Nabi Ilyas menurunkan bencana, dan akhirnya kekeringan melanda daerah tersebut. Setelah beberapa tahun, Nabi Ilyas dapat meyakinkan kaum tersebut untuk menyembah Allah SWT");
        insertNamaNabi(db, 20, "Nabi Ilyasa AS", "Nabi Ilyasa merupakan kerabat dekat Nabi Ilyas. Setelah Nabi Ilyas meninggal, beliau melanjutkan perjuangan Nabi Ilyas untuk menghalau penyembahan berhala yang kembali merebak di lembah sungai Yordan. Namun kaum tersebut tidak mau mendengarkan sehingga terjadi bencana kekeringan kembali melanda mereka");
        insertNamaNabi(db, 21, "Nabi Yunus AS", "Nabi yunus berusaha menyebarkan ajaran Allah, namun ia tidak mendapat sambutan baik dari masyarakat. Dalam perjalanannya menjauhi daerah tersebut karena khawatir akan dibunuh, kapal yang ia tumpangi diguncang topan dan diputuskan bahwa Nabi Yunus akan dikorbankan untuk ditenggelamkan ke laut demi keselamatan penumpang lainnya. Namun mukjizat Allah tiba, Nabi Yunus dimakan oleh seekor ikan yang kemungkinan adalah ikan paus, dan ditemukan masih hidup didalam perut ikan paus tersebut");
        insertNamaNabi(db, 22, "Nabi Zakaria AS", "Nabi Zakaria dan istrinya, Isya, membaktikan diri untuk menjaga Baitul Maqdis - Rumah Ibadah peninggalan Nabi Sulaiman di Yerusalem. Nabi Zakaria dikaruniai keturunan oleh Allah SWT di saat usianya sudah cukup uzur, yaitu sekitar 100 tahun, anak tersebut adalah Nabi Yahya");
        insertNamaNabi(db, 23, "Nabi Yunus AS", "Nabi Yahya mengajarkan bahwa kebenaran harus ditegakkan dengan resiko apapun. Pada riwayatnya dicontohkan saat ia bersikeras melarang pernikahan antara seorang paman dengan keponakannya sendiri");
        insertNamaNabi(db, 24, "Nabi Isa AS", "Nabi Isa adalah putra dari Bunda Maryam yang dilahirkan tanpa memiliki suami, Hal ini menimbulkan kontroversi dan hujatan bertubi-tubi kepada Maryam. Secara ajaib Nabi Isa yang saat itu masih bayi tiba-tiba berbicara dan menjelaskan apa yang sebenarnya terjadi. Bahwa penciptaan dirinya diawalai dari kedatangan malaikat jibril kepada ibunya. Nabi Isa juga memperlihatkan banyak mukjizat lainnya ketika ia tumbuh dewasa, diantaranya membentuk seekor burung hidup dari sebuah tanah liat, menghidupkan orang mati, menyembuhkan kebutaan dan mendatangkan makanan yang semula tidak ada dan menjadi ada. Penyelamatan Nabi Isa dari penyaliban juga merupakan salah satu bentuk mukjizat yang diberikan oleh Allah SWT");
        insertNamaNabi(db, 25, "Nabi Muhammad SAW", "Nabi Muhammad SAW adalah Rasul terakhir, sekaligus sebagai penutup para Rasul-Rasul sebelumnya. Dia lah yang menyempurnakan ajaran-ajaran Islam.Mukjizat yang diturunkan Allah kepadanya sangatlah banyak, salah satunya yang paling besar adalah Al-Qur''an, yang menjadi pedoman utama kehidupan manusia. Selain itu ada pula peristiwa Isra Mi''raj yang membawanya bertemu dengan Allah SWT");
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
