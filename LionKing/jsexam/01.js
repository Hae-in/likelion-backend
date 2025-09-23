console.log("hi");

// ES6
// let: 변수
// const: 상수
// var: 권장x

// var
// 1. 중복 선언이 된다.
// 2. 호이스팅 된다.
// 3. 변수의 스코프가 함수단위⭐️로 사용된다.
// 왜 ES6에서 var를 지양하고 let, const를 추가했는지 이유?

var v1 = 10;
var v1 = 20;
var v1 = 30;
console.log(v1);

// 중복 선언 되었을때 문제점??

console.log(v2);

var v2 = 20;
console.log(v2);
// console.log(v3);


varScopeTest(); // 함수 호이스팅
function varScopeTest() {
    if (true) {
        var varScope = 1000;
    }
    console.log(varScope);
}

varScopeTest();

// 자바는 강형: 값에 따라서 타입이 다르다.
// 자바스크립트는 약형: 타입이 정해지지 않는다.
console.log("=== let ===")
// console.log(value); // 당연히 호이스팅 되지 않는다.

let value = 123;
console.log(value);

value = "aa";
console.log(value);

// let, value = 20; // 당연히 중복정의 안됨

function letScopeTest() {
    if (true) {
        var letScope = 2000;
    }
    // console.log(letScope); // let scope 가 블럭단위로 사용된다.
}

letScopeTest();

console.log("=== const ===")
const a = 10;
// a = 20; // 상수이므로 값 변경이 안됨! 나머지 특징은 let과 동일
