package com.example.regapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)




        val itemsList: RecyclerView = findViewById(R.id.items_list)
        val items = arrayListOf<Item>()

        items.add(Item(1, "tango", "Tango", "health recovery fruit", "Съедает дерево, увеличивая восстановление здоровья на 7. Действует 16 сек. Если съесть деревце от Iron Branch, то восстановится в два раза больше здоровья.\n" +
                " \n" +
                "Изначально имеет 3 заряда. Можно применить на союзного героя, чтобы дать ему один Tango.\n" +
                "\n" +
                "Бонус к регенерации здоровья: 7\n" +
                "Длительность (Дерево): 16\n" +
                "Длительность (Посаженное дерево): 32\n" +
                "Дальность применения: 165\n" +
                "Изначальное количество зарядов: 3\n" +
                "Время жизни Tango (не свой): 40", 80 ))
        items.add( Item(2, "mango", "Mango", "magic recovery bottle", "Активируемая: Eat Mango.\n" +
                "\n" +
                "\n" +
                "Мгновенно восстанавливает 100 маны.\n" +
                "\n" +
                "\n" +
                "Дальность применения: 400\n" +
                "Восстанавливает маны: 100\n" +
                "\n" +
                "+ 0,4 к восстановлению здоровья", 50 ))
        items.add(Item(3, "magic_stick", "Magic Stick", "health and Magic recovery item", "Активируемая: Energy Charge.\n" +
                "                       \n" +
                "Мгновенно восстанавливает 15 здоровья и маны за каждый имеющийся заряд. Может иметь до 10 зарядов. Получает один заряд каждый раз, когда видимый враг в радиусе 1200 использует способность.\n" +
                "                       \n" +
                "Радиус: 1200\n" +
                "Зарядов за способность: 1\n" +
                "Максимум зарядов: 10\n" +
                "Восст. здоровья и маны за заряд: 15" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 180 ))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemAdapter(items, this)

    }
}