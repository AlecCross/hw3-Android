package com.example.userlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

class User {
    // ----- Class constants -----------------------------------------------
    //    - Id ресурса с аватаром
    //public int id;
    //- Имя
    public String firstName;
    //- Фамилия
    public String lastName;
    //- Возраст (хранить в формате long UTC)
    public Integer age;
    //- Страна
    public String country;
    //- Город
    public String city;


    // ----- Class methods -------------------------------------------------
    public User(String firstName, String lastName, Integer age, String country, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.country = country;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Name : " + this.firstName + " " + this.lastName + ", Age : " + this.age + ",  " + this.country + ",  " + this.city;
    }
}

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // набор данных, которые свяжем со списком
        String[] firstNames = {"Ricardo", "Juan", "Anderson", "Edson", "Лиото", "Royce", "Vicente", "Michel", "Nate", "Tony"};
        String[] lastNames = {"Milos", "Borja", "Silva", "Barbosa", "Мачида", "Gracie", "Luke", "Pereira", "Diaz", "Ferguson"};
        String[] countries = {"Гваделупа", "Аргентина", "Колумбия"};
        String[] cities1 = {"Бас-Тер", "Пуэнт-а-Питр", "Мари-Галант", "Ла-Дезирад", "Ле-Сент"};
        String[] cities2 = {"Буэнос-Айрес", "Кордова", "Росарио", "Мар-дель-Плата", "Сан-Мигель-де-Тукуман"};
        String[] cities3 = {"Богота", "Медельин", "Кали", "Барранкилья", "Картахена"};

        ArrayList<User> users = new ArrayList<>();
//        users.add(new User("firstName1", "lastname1", 1, "Гваделупа1", "ывпвп1"));
//        users.add(new User("firstName2", "lastname2", 3, "Гваделупа2", "ывпвп2"));
//        users.add(new User("firstName3", "lastname3", 2, "Гваделупа3", "ывпвп3"));
//        users.add(new User("firstName4", "lastname4", 4, "Гваделупа4", "ывпвп4"));

        for (int i = 0; i <= 5; i++) {
            Random rand = new Random();
            //int randomName = minimum + rand.nextInt((maximum - minimum) + 1);
            int randomFirstName = 0 + rand.nextInt((10 - 0));
            int randomLastName = 0 + rand.nextInt((10 - 0));
            int randomCountry = 0 + rand.nextInt((3 - 0));
            int randomCity = 0 + rand.nextInt((5 - 0));

            if (randomCountry == 0) {
                users.add(new User(firstNames[randomFirstName], lastNames[randomLastName], 1, countries[randomCountry], cities1[randomCity]));
//                users.add(new User(firstNames[1], lastNames[1], 1, countries[1], cities1[1]));
            } else if (randomCountry == 1) {
                users.add(new User(firstNames[randomFirstName], lastNames[randomLastName], 1, countries[randomCountry], cities2[randomCity]));
//                users.add(new User(firstNames[2], lastNames[2], 2, countries[2], cities2[4]));
            } else {
                users.add(new User(firstNames[randomFirstName], lastNames[randomLastName], 1, countries[randomCountry], cities3[randomCity]));
//                users.add(new User(firstNames[3], lastNames[3], 3, countries[3], cities3[4]));
            }
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // получаем элемент ListView
        ListView countriesList = (ListView) findViewById(R.id.countriesList);

        // создаем адаптер
        ArrayAdapter<User> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, users);

        // устанавливаем для списка адаптер
        countriesList.setAdapter(adapter);
    }
}