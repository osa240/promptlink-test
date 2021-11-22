# Тестовое задание:

Реализовать класс - коллекцию(множество) с ограниченным размером. \
Класс должен реализовывать следующий интерфейс:

```java
public interface LimitedSet<T> {
void add(final T t);
boolean remove(final T t);
boolean contains(final T t);
}
```
Размер множества не может превышать 10 элементов.

Доступны операции добавления, удаления и проверка наличия элемента.

Если при добавлении очередного элемента размер множества превышает \
10 - то удаляется элемент, к которому было наименьшее количество \
обращений - ( вызовов метода contains() )

Если таких элементов несколько - удаляется любой один из них.