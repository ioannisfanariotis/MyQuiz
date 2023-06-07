package com.example.elearningquizapplication.utils

import com.example.elearningquizapplication.R

object Constants {

    fun getGeography():ArrayList<Geography> {
        val geographyList = ArrayList<Geography>()

        val q1 = Geography(1, R.drawable.estonia, "Λετονία", "Εσθονία", "Αυστρία", "Λιθουανία", 2)
        geographyList.add(q1)

        val q2 = Geography(2, R.drawable.slovakia, "Σερβία", "Σλοβενία", "Κροατία", "Σλοβακία", 4)
        geographyList.add(q2)

        val q3 = Geography(3, R.drawable.bosnia, "Μαυροβούνιο", "Αζερμπαϊτζάν", "Λευκορωσία", "Βοσνία Ερζεγοβίνη", 4)
        geographyList.add(q3)

        val q4 = Geography(4, R.drawable.denmark, "Φινλανδία", "Ισλανδία", "Δανία", "Σουηδία", 3)
        geographyList.add(q4)

        val q5 = Geography(5, R.drawable.latvia, "Λετονία", "Εσθονία", "Αυστρία", "Λιθουανία", 1)
        geographyList.add(q5)

        val q6 = Geography(6, R.drawable.croatia, "Σερβία", "Σλοβενία", "Κροατία", "Σλοβακία", 3)
        geographyList.add(q6)

        val q7 = Geography(7, R.drawable.belarus, "Μαυροβούνιο", "Αζερμπαϊτζάν", "Λευκορωσία", "Βοσνία Ερζεγοβίνη", 3)
        geographyList.add(q7)

        val q8 = Geography(8, R.drawable.finland, "Φινλανδία", "Ισλανδία", "Δανία", "Σουηδία", 1)
        geographyList.add(q8)

        val q9 = Geography(9, R.drawable.lithuania, "Λετονία", "Εσθονία", "Αυστρία", "Λιθουανία", 4)
        geographyList.add(q9)

        val q10 = Geography(10, R.drawable.slovenia, "Σερβία", "Σλοβενία", "Κροατία", "Σλοβακία", 2)
        geographyList.add(q10)

        return geographyList
    }

    fun getPhysics():ArrayList<Physics> {
        val physicsList = ArrayList<Physics>()
        val q1 = Physics(1, "Αντικείμενα με μεγαλύτερη πυκνότητα θα βυθίζονται πάντα στο νερό.", 1)
        physicsList.add(q1)

        val q2 = Physics(2, "Η επιτάχυνση λόγω βαρύτητας είναι ίδια για όλα τα αντικείμενα, ανεξάρτητα από τη μάζα τους.", 1)
        physicsList.add(q2)

        val q3 = Physics(3, "Σε ένα κενό, όλα τα αντικείμενα πέφτουν με τον ίδιο ρυθμό, ανεξάρτητα από τη μάζα τους.", 1)
        physicsList.add(q3)

        val q4 = Physics(4, "Για να κρατηθεί ένα αντικείμενο σε σταθερή ταχύτητα, απαιτείται μια δύναμη.", 2)
        physicsList.add(q4)

        val q5 = Physics(5, "Η ενέργεια πάντα διατηρείται σε ένα κλειστό σύστημα.", 1)
        physicsList.add(q5)

        val q6 = Physics(6, "Η ταχύτητα του φωτός είναι μεγαλύτερη από την ταχύτητα του ήχου.", 1)
        physicsList.add(q6)

        val q7 = Physics(7, "Η θερμοκρασία και η θερμότητα είναι το ίδιο πράγμα.", 2)
        physicsList.add(q7)

        val q8 = Physics(8, "Η τριβή πάντα αντιδρά την κίνηση ενός αντικειμένου.", 1)
        physicsList.add(q8)

        val q9 = Physics(9, "Η ηλεκτρική ρεύματος ρέει από το θετικό πόλο προς τον αρνητικό πόλο μιας μπαταρίας.", 2)
        physicsList.add(q9)

        val q10 = Physics(10, "Ο ήχος ταξιδεύει γρηγορότερα μέσω των στερεών από ό,τι μέσω των αερίων.", 1)
        physicsList.add(q10)

        return physicsList
    }

    fun getProgramming(): ArrayList<Programming> {
        val programmingList = ArrayList<Programming>()
        val q1 = Programming(1, "Ποιος είναι ο σκοπός ενός βρόχου στον προγραμματισμό;",
            "Να εκτελεί μαθηματικούς υπολογισμούς",
            "Να επαναλαμβάνει ένα τμήμα κώδικα",
            "Να ορίζει συναρτήσεις", 2)
        programmingList.add(q1)

        val q2 = Programming(2, "Ποια είναι η σύνταξη για τη δήλωση μιας μεταβλητής στην Python;",
            "variable = value",
            "var value = variable",
            "variable value = variable", 1)
        programmingList.add(q2)

        val q3 = Programming(3, "Ποιο είναι το αποτέλεσμα του ακόλουθου τμήματος κώδικα; print(2 + 3 * 4)",
            "20",
            "14",
            "9", 2)
        programmingList.add(q3)

        val q4 = Programming(4, "Ποιος τύπος δεδομένων χρησιμοποιείται για να αποθηκεύσετε μια ακολουθία χαρακτήρων στην Python;",
            "Float",
            "Boolean",
            "String", 3)
        programmingList.add(q4)

        val q5 = Programming(5, "Τι σημαίνει το ακρωνύμιο HTML;",
            "HyperText Markup Language (Γλώσσα Σήμανσης Υπερκειμένου)",
            "Home Tool Markup Language (Γλώσσα Σήμανσης Εργαλείων Οικιακής Χρήσης)",
            "Hypermedia Text Markup Language (Γλώσσα Σήμανσης Υπερμέσων και Κειμένου)", 1)
        programmingList.add(q5)

        val q6 = Programming(6, "Ποια γλώσσα προγραμματισμού χρησιμοποιείται συχνά για την ανάπτυξη κινητών εφαρμογών;",
            "JavaScript",
            "C++",
            "Swift", 3)
        programmingList.add(q6)

        val q7 = Programming(7, "Ποιος είναι ο σκοπός του CSS στην ανάπτυξη ιστοσελίδων;",
            " Να προσθέτει αλληλεπίδραση και λειτουργικότητα σε μια ιστοσελίδα",
            "Να χειρίζεται λειτουργίες στην πλευρά του διακομιστή",
            "Να διαμορφώνει την οπτική εμφάνιση μιας ιστοσελίδας", 3)
        programmingList.add(q7)

        val q8 = Programming(8, "Ποιο είναι το σύμβολο που χρησιμοποιείται για μονογραμμικά σχόλια στις περισσότερες γλώσσες προγραμματισμού;",
            "//",
            "/*",
            "#", 1)
        programmingList.add(q8)

        val q9 = Programming(9, "Τι σημαίνει ο όρος API;",
            "Application Program Interaction (Διάδραση Προγράμματος Εφαρμογής)",
            " Application Programming Interface (Διεπαφή Προγραμματισμού Εφαρμογών)",
            "Automated Program Integration (Αυτοματοποιημένη Ενσωμάτωση Προγράμματος)", 2)
        programmingList.add(q9)

        val q10 = Programming(10, "Ποια από τις παρακάτω είναι παράδειγμα αντικειμενοστραφούς γλώσσας προγραμματισμού;",
            "Java",
            "Assembly",
            "C", 1)
        programmingList.add(q10)

        return programmingList
    }
}