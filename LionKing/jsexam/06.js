// 함수

// 자바스크립트는 함수를 일급객체로 취급한다.
// 함수도 타입이 될 수 있다: 타입이 된다라는 것은 매개변수로도 사용가능, 리턴값으로도 사용가능..
function test() {
    console.log("Hello");
}

console.log(typeof test);

function func2(abc) {
    return abc;
}

let value = 10;
let result = func2(value);
console.log(result);

let result2 = func2(test); // 함수의 매개변수로 함수가 들어감
console.log(result2); // [Function: test]

function func3(abc) {
    return abc(); // 함수를 실행하고 함수가 전달
}

let result3 = func3(test); // 함수가 전달될때 () 쓰는것과 쓰지않은것의 차이점?
// result3();



// 함수 호이스팅
hello();
function hello() {
    console.log("hello 호이스팅");
}

function hello() {
    console.log("hello 호이스팅222"); // 중복 정의 가능! 중복일 경우, 나중에 정의된 함수가 실행
}

// 함수 선언식
function add(a, b) {
    return a + b;
}
console.log(add(5, 3));  // 8
let addresult = add(20, 20);
console.log(addresult);


// 화살표 함수
const hi1 = (a) => console.log("hi" + a);
const hi2 = (a, b) => console.log("hi" + a + b);
hi1("tetest");
hi2("tetest", "asdasd");

const add2 = (a, b) => {
    return a+b;
}
console.log(add2(10, 20));

const add3 = (a, b) => a+b;
console.log(add3(10, 20));


// 화살표 함수안에서의 this: 항상 전역을 의미함. (우리가 정의한 객체 안에서 사용할 때)



// 오버로딩 안된다
console.log("=== === === === 오버로딩 테스트 === === === ===");
function func4(a) {
    console.log("a+a");
    return a+a;
}

function func4(a, b) {
    console.log("a+b");
    console.log(arguments.length);
    console.log("4번째 매개변수: " + arguments[3]);
    console.log(" ");
    return a+b;
}

let func1Result = func4(10);
console.log("func1Result = " + func1Result);
// console.log(func4(10,20));
// console.log(func4(10,20, 30));
// console.log(func4(10,20, 30, 40));
console.log(func4(10,20, 30, 40, 50));
