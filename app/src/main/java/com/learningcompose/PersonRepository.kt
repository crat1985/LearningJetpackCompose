package com.learningcompose


class PersonRepository {
    companion object{
        fun getAllDatas(): List<Person>{
            val list = mutableListOf<Person>()

            for (i in 1..5000) {
                list += Person("Name$i", "LASTNAME$i", 15)
            }

            return list
        }
    }
}
