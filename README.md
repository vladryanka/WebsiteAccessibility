Задание:
Создайте программу, которая асинхронно будет проверять доступность списка веб-сайтов.

Создайте список веб-сайтов, которые будут проверяться на доступность.
Напишите функцию checkWebsite(url: String), которая будет проверять доступность веб-сайта по заданному url и возвращать true, если сайт доступен, и false, если недоступен.
Используя конструкцию async в Kotlin Coroutines, запустите проверку доступности всех веб-сайтов из списка параллельно.
Результаты проверки доступности каждого сайта выведите на экран в формате 'Сайт [url] доступен/недоступен'.
Приложение должно быть реализовано с использованием консольного интерфейса.