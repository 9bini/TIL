# 11.13 예외를 사전확인으로

## 전

```java
double getValueForPeriod(int periodNumber){
    try{
        return values[periodNumber];
    }catch(ArrayIndexOutOfBoundsException e){
        return;
    }
}
```

## 후

```java
double getValueForPeriod(int periodNumber){
    return (periodNumber >= values.length)?0:values[periodNumber];
}
```

## 배경

- 예외는 뜻밖의 오류라는 , 말 그대로 예외적으로 동작할 때만 쓰여야한다.

## 예시 (자바)

```java
public Resource get(){
    Resource result;
    try{
        result = available.pop();
        allocated.add(result);
    }catch(NoSuchElementException e){
        result = Resouce.create();
        allocated.add(result);
    }
    return result;
}
private Deque<Resource> available;
private List<Resource> allocated;
```

### 조건을 검사하는 코드 추가, catch 블록의 코드를 조건문의 조건절로 옮기기, 남은 try 블록 코드를 다른 조건절로 옮기기

```java
public Resource get(){
    Resource result;
    if(available.isEmpty){
        result = Resouce.create();
        allocated.add(result);
    }else{
        try{
            result = available.pop();
            allocated.add(result);
        }catch(NoSuchElementException e){}
    }
    return result;
}
private Deque<Resource> available;
private List<Resource> allocated;
```

### catch 절은 더이상 호출되지 않으므로 어서션을 추가한다.

```java
public Resource get(){
    Resource result;
    if(available.isEmpty){
        result = Resouce.create();
        allocated.add(result);
    }else{
        try{
            result = available.pop();
            allocated.add(result);
        }catch(NoSuchElementException e){
            throw new AssertionError("도달 불가");
        }
    }
    return result;
}
private Deque<Resource> available;
private List<Resource> allocated;
```

### 어서션까지 추가한 후 테스트에 통과하면 try 키워드와 catch블록을 삭제한다.

```java
public Resource get(){
    Resource result;
    if(available.isEmpty){
        result = Resouce.create();
        allocated.add(result);
    }else{
        result = available.pop();
        allocated.add(result);
    }
    return result;
}
private Deque<Resource> available;
private List<Resource> allocated;
```

### 더 가다듬기 - 문장 슬라이드하기, 3항 연산자로 변경

```java
public Resource get(){
    Resource result = available.isEmpty ? Resouce.create():available.pop();
    allocated.add(result);
    return result;
}
private Deque<Resource> available;
private List<Resource> allocated;
```
