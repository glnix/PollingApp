package com.example.pollingapp.data.repository

import com.example.pollingapp.data.Answer
import com.example.pollingapp.data.Poll
import com.example.pollingapp.data.Question

fun getPolls(): List<Poll> = listOf(makePoll1(), makePoll2())

fun makePoll1() = Poll(
    id = 1,
    name = "Опрос №1",
    questions = listOf(
        Question(
            id = 1,
            title = "Вопрсос 1",
             answers = listOf(
                Answer(
                    id = 1,
                    title = "Вариант 1",
                ),
                Answer(
                    id = 2,
                    title = "Вариант 2",
                ),
                Answer(
                    id = 3,
                    title = "Вариант 3",
                ),
                Answer(
                    id = 4,
                    title = "Вариант 4",
                )
            )

        ),
        Question(
            id = 2,
            title = "Вопрсос 2",
            answers = listOf(
                Answer(
                    id = 1,
                    title = "Вариант 1",
                ),
                Answer(
                    id = 2,
                    title = "Вариант 2",
                ),
                Answer(
                    id = 3,
                    title = "Вариант 3",
                )
            )

        )
    )
)

fun makePoll2() = Poll(
    id = 2,
    name = "Опрос №2",
    questions = listOf(
        Question(
            id = 1,
            title = "Вопрсос 1",
            listOf(
                Answer(
                    id = 1,
                    title = "Вариант 1",
                ),
                Answer(
                    id = 2,
                    title = "Вариант 2",
                ),
                Answer(
                    id = 3,
                    title = "Вариант 3",

                ),
                Answer(
                    id = 4,
                    title = "Вариант 4",
                )
            )

        ),
        Question(
            id = 2,
            title = "Вопрсос 2",
            listOf(
                Answer(
                    id = 1,
                    title = "Вариант 1",
                ),
                Answer(
                    id = 2,
                    title = "Вариант 2",
                ),
                Answer(
                    id = 3,
                    title = "Вариант 3",
                ),
                Answer(
                    id = 4,
                    title = "Вариант 4",
                )
            )

        ),
        Question(
            id = 3,
            title = "Вопрсос 3",
            answers = listOf(
                Answer(
                    id = 1,
                    title = "Вариант 1",
                ),
                Answer(
                    id = 2,
                    title = "Вариант 2",
                ),
                Answer(
                    id = 3,
                    title = "Вариант 3",

                    ),
                Answer(
                    id = 4,
                    title = "Вариант 4",
                )
            )

        ),
    )
)