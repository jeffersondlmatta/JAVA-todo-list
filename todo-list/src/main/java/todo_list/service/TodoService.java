package todo_list.service;

import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortArgumentResolver;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import todo_list.entity.Todo;
import todo_list.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {
    private final SortArgumentResolver sortArgumentResolver;
    private TodoRepository todoRepository;
    //cria contructor
    public TodoService(TodoRepository todoRepository, SortArgumentResolver sortArgumentResolver) {
        this.todoRepository = todoRepository;
        this.sortArgumentResolver = sortArgumentResolver;
    }

    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return list();

    }
    public List<Todo> list() {
        Sort sort = Sort.by(Sort.Order.desc("prioridade"))
                .and(Sort.by(Sort.Order.asc("nome")));
        return todoRepository.findAll(sort);
    }
    public List<Todo> update(Todo todo) {
        todoRepository.save(todo);

        return list();

    }
    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }

}

