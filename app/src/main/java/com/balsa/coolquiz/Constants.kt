package com.balsa.coolquiz

object Constants{

    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val q1 = Question(0, "Koliko nogu ima macka", "1", "2", "3", "4", 4)
        val q2 = Question(1, "Koliko nogu ima majmun", "1", "2", "3", "4", 2)
        val q3 = Question(2, "Akrofobični ljudi se boje", "Visine", "Zmije", "Uskog prostora", "Pauka", 1)
        val q4 = Question(3, "U kojoj se državi nalazi Angkor Wat, najveći hramski / religijski kompleks na svijetu?", "Tajland", "Peru", "Kambodža", "Vijetnam", 3)
        val q5 = Question(4, "U kojem se ruskom gradu nalazi Državni muzej Ermitaž?", "Omsk", "Volgograd", "Moskva", "Sankt-Peterburg", 4)
        val q6 = Question(5, "Koliko krugova Pakla ima u Danteovoj Božanstvenoj komediji?", "Sedam", "Devet", "Trinaest", "Dvanaest", 2)
        val q7 = Question(6, "Koji je glavni grad Kolumbije?", "Bogota", "Managua", "Tijuana", "Medellin", 1)
        val q8 = Question(7, "Gdje su se prvo počele koristiti papirne novčanice ?", "Portugal", "Kina", "Indija", "Egipat", 2)
        val q9 = Question(8, "Najviši vodopad na svijetu je", "Anđelov vodopad", "Iguazú vodopad", "Slapovi Niagare", "Fadamijski vodopad", 1)
        val q10 = Question(9, "Drugi svjetski rat je završen ?", "25. maja 1945.", "7. oktobra 1945.", "5. novembra 1945.", "2. septembra 1945.", 4)
        val q11 = Question(10, "Marie Antoinette (Marija Antoaneta) je bila", "Francuska kraljica", "Poznati poslastičar", "Engleska kraljica", "Operska pjevačica", 1)
        val q12 = Question(11, "Prije solo karijere, Sting je bio glavni tekstopisac, pjevač i basista rock grupe", "Oasis", "The Clash", "The Who", "The Police", 4)
        val q13 = Question(12, "Epski roman “Rat i mir” napisao je", "Sergej Aleksandrovič Jesenjin", "Fjodor Mihajlovič Dostojevski", "Lav Nikolajevič Tolstoj", "Johann Wolfgang von Goethe", 3)

        questionList.add(q1)
        questionList.add(q2)
        questionList.add(q3)
        questionList.add(q4)
        questionList.add(q5)
        questionList.add(q6)
        questionList.add(q7)
        questionList.add(q8)
        questionList.add(q9)
        questionList.add(q10)
        questionList.add(q11)
        questionList.add(q12)
        questionList.add(q13)

        return questionList
    }
}