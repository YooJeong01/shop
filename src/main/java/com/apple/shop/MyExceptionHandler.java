// REST API 안 쓰고, 타임리프만 써서 코드 비활성화 해 둠

//package com.apple.shop;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
//
//@ControllerAdvice
//public class MyExceptionHandler {
//
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    public ResponseEntity<String> handler1(){
//        return ResponseEntity.status(400).body("에러남");
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handler2(){
//        return ResponseEntity.status(400).body("에러남");
//    }
//}
