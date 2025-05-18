package com.example.myapplication.data

import androidx.compose.runtime.mutableStateListOf
import com.example.myapplication.R
import com.example.myapplication.models.Book
import com.example.myapplication.models.Genre


val genres = mutableStateListOf(
    Genre(1, "Informatyka"),
    Genre(2, "Fizyka"),
    Genre(3, "Inne")
)

val books = mutableStateListOf(
    Book("Atomowe nawyki", 3, "James Clear", "Praktyczny poradnik jak zmieniać nawyki i budować lepsze życie.", R.drawable.atomowe_nawyki),
    Book("Deep Learning with Python", 1, "François Chollet", "Wprowadzenie do deep learningu z Keras i Pythonem.", R.drawable.deep_learning),
    Book("Fizyka. Repetytorium", 2, "Opracowanie zbiorowe", "Kompendium wiedzy z fizyki dla uczniów szkół średnich.", R.drawable.fizyka_podrecznik),
    Book("Zbiór zadań z fizyki", 2, "Opracowanie zbiorowe", "Zbiór zadań z rozwiązaniami dla uczniów szkół ponadpodstawowych.", R.drawable.fizyka_repetytorium),
    Book("10 głupstw, które robią mężczyźni...", 3, "Dr. Laura Schlessinger", "Jak uniknąć błędów i komplikacji w życiu osobistym.", R.drawable.glupstw10),
    Book("Informatyka. Zakres podstawowy", 1, "Opracowanie zbiorowe", "Podręcznik informatyki dla szkół ponadgimnazjalnych.", R.drawable.inf1),
    Book("Informatyka. Zakres rozszerzony", 1, "Opracowanie zbiorowe", "Zaawansowany podręcznik informatyki dla uczniów liceum i technikum.", R.drawable.informatyka_podrecznik),
    Book("Jak zdobyć przyjaciół i zjednać sobie ludzi", 3, "Dale Carnegie", "Klasyczny poradnik komunikacji i relacji międzyludzkich.", R.drawable.jak_zdobyc_przyjaciol),
    Book("Nie mamy pojęcia", 2, "Jorge Cham, Daniel Whiteson", "Zabawne wprowadzenie do największych tajemnic fizyki.", R.drawable.nie_mamy_pojecia),
    Book("Oskar i pani Róża", 3, "Éric-Emmanuel Schmitt", "Poruszająca opowieść o życiu, śmierci i nadziei widzianej oczami dziecka.", R.drawable.oskaripaniroza),
    Book("Pan Tadeusz", 3, "Adam Mickiewicz", "Narodowa epopeja romantyczna osadzona w czasach szlacheckich.", R.drawable.pan_tadeusz),
    Book("Przygody Tomka Sawyera", 3, "Mark Twain", "Zabawne i pełne przygód dzieciństwo chłopca nad Missisipi.", R.drawable.przygody_tomka_sawyera),
    Book("Sherlock Holmes", 3, "Arthur Conan Doyle", "Klasyczne opowiadania detektywistyczne z genialnym Holmesem.", R.drawable.sherlockholmes),
    Book("Uczenie maszynowe z użyciem scikit-learn", 1, "Aurélien Géron", "Praktyczne wprowadzenie do machine learningu w Pythonie.", R.drawable.uczenia_maszynowe),
    Book("Wszechświat w twojej dłoni", 2, "Christophe Galfard", "Przystępne wyjaśnienie kosmosu i fizyki dla każdego.", R.drawable.wszechswiat_w_twojej_dloni)
)