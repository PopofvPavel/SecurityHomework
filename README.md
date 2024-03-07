В ветке main реализована form login аутентификация, пользователи в ней берутся из БД(использовал Postgres) - скрипт прикреплен(script.sql)
В БД есть пользователи:
user1 (password1) - USER, ADMIN
user2 (password2) - USER
moder (moder) - MODERATOR
Также написаны тесты для доступа по ролям.
В ветке basic реализована basic аутентификация, пользователи хранятся в памяти:
user1 (password1) - USER, ADMIN
moder (moder) - MODERATOR
