package com.github.core.common.contant

const val SCORE_INT_EXTRA = "score_int_extra"
const val SCORE_DATA_EXTRA = "score_data_extra"

object QuestionsData {
    fun calculateTotalScore(score: Int): Score = when (score) {
        in 0..13 -> Score.TIDAK_ADA
        in 14..20 -> Score.RINGAN
        in 21..27 -> Score.SEDANG
        in 28..41 -> Score.BERAT
        in 42..56 -> Score.BERAT_SEKALI
        else -> Score.TIDAK_ADA
    }

    val questions = listOf(
        "Perasaan Ansietas - Cemas\n" +
                "- Firasat Buruk\n" +
                "- Takut Akan Pikiran Sendiri\n" +
                "- Mudah Tersinggung",
        "Ketegangan\n" +
                "- Merasa Tegang\n" +
                "- Lesu\n" +
                "- Tak Bisa Istirahat Tenang\n" +
                "- Mudah Terkejut\n" +
                "- Mudah Menangis\n" +
                "- Gemetar\n" +
                "- Gelisah",
        "Ketakutan\n" +
                "- Pada Gelap\n" +
                "- Pada Orang Asing\n" +
                "- Ditinggal Sendiri\n" +
                "- Pada Binatang Besar\n" +
                "- Pada Keramaian Lalu Lintas\n" +
                "- Pada Kerumunan Orang Banyak",
        "Gangguan Tidur\n" +
                "- Sukar Masuk Tidur\n" +
                "- Terbangun Malam Hari\n" +
                "- Tidak Nyenyak\n" +
                "- Bangun dengan Lesu\n" +
                "- Banyak Mimpi-Mimpi\n" +
                "- Mimpi Buruk\n" +
                "- Mimpi Menakutkan",
        "Gangguan Kecerdasan\n" +
                "- Sukar Konsentrasi\n" +
                "- Daya Ingat Buruk",
        "Perasaan Depresi\n" +
                "- Hilangnya Minat\n" +
                "- Berkurangnya Kesenangan Pada Hobi\n" +
                "- Sedih\n" +
                "- Bangun Dini Hari\n" +
                "- Perasaan Berubah-Ubah Sepanjang Hari",
        "Gejala Somatik (Otot)\n" +
                "- Sakit dan Nyeri di Otot-Otot\n" +
                "- Kaku\n" +
                "- Kedutan Otot\n" +
                "- Gigi Gemerutuk\n" +
                "- Suara Tidak Stabil",
        "Gejala Somatik (Sensorik)\n" +
                "- Tinitus\n" +
                "- Penglihatan Kabur\n" +
                "- Muka Merah atau Pucat\n" +
                "- Merasa Lemah\n" +
                "- Perasaan ditusuk-Tusuk",
        "Gejala Kardiovaskuler\n" +
                "- Takhikardia\n" +
                "- Berdebar\n" +
                "- Nyeri di Dada\n" +
                "- Denyut Nadi Mengeras\n" +
                "- Perasaan Lesu/Lemas Seperti Mau Pingsan\n" +
                "- Detak Jantung Menghilang (Berhenti\n" +
                "Sekejap)",
        "Gejala Respiratori\n" +
                "- Rasa Tertekan atau Sempit Di Dada\n" +
                "- Perasaan Tercekik\n" +
                "- Sering Menarik Napas\n" +
                "- Napas Pendek/Sesak",
        "Gejala Gastrointestinal\n" +
                "- Sulit Menelan\n" +
                "- Perut Melilit\n" +
                "- Gangguan Pencernaan\n" +
                "- Nyeri Sebelum dan Sesudah Makan\n" +
                "- Perasaan Terbakar di Perut\n" +
                "- Rasa Penuh atau Kembung\n" +
                "- Mual\n" +
                "- Muntah\n" +
                "- Buang Air Besar Lembek\n" +
                "- Kehilangan Berat Badan\n" +
                "- Sukar Buang Air Besar (Konstipasi)",
        "Gejala Urogenital\n" +
                "- Sering Buang Air Kecil\n" +
                "- Tidak Dapat Menahan Air Seni\n" +
                "- Amenorrhoe\n" +
                "- Menorrhagia\n" +
                "- Menjadi Dingin (Frigid)\n" +
                "- Ejakulasi Praecocks\n" +
                "- Ereksi Hilang\n" +
                "- Impotensi",
        "Gejala Otonom\n" +
                "- Mulut Kering\n" +
                "- Muka Merah\n" +
                "- Mudah Berkeringat\n" +
                "- Pusing, Sakit Kepala\n" +
                "- Bulu-Bulu Berdiri",
        "Tingkah Laku Pada Wawancara\n" +
                "- Gelisah\n" +
                "- Tidak Tenang\n" +
                "- Jari Gemetar\n" +
                "- Kerut Kening\n" +
                "- Muka Tegang\n" +
                "- Tonus Otot Meningkat\n" +
                "- Napas Pendek dan Cepat\n" +
                "- Muka Merah"
    )
}