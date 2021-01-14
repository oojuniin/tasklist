# tasklist

## CRUD simples SPRING-BOOT, POSTGRESQL

```
https://tasklist-oojuniin.herokuapp.com/api/tasks
```

```
Criar uma nova tarefa
[POST] https://tasklist-oojuniin.herokuapp.com/api/tasks

{
  "title": "Lavar",
  "description": "Limpeza",
  "status":"PENDING"
}
```

```
Buscar todas as tarefas
[GET] https://tasklist-oojuniin.herokuapp.com/api/tasks/
```

```
Buscar uma tarefa pelo nome
[GET] https://tasklist-oojuniin.herokuapp.com/api/tasks/nome-da-tarefa
```

```
Atualizar uma tarefa
[PUT] https://tasklist-oojuniin.herokuapp.com/api/tasks/1

{
  "title": "Lavar",
  "description": "Limpeza",
  "status":"PENDING"
}
```

```
Deletar uma tarefa
[DELETE] https://tasklist-oojuniin.herokuapp.com/api/tasks/1
```
