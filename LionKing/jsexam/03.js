// 데이터 타입
let name = "자바스크립트";
console.log(typeof name);

let isActive = true;
console.log(typeof isActive);

let message = "안녕하세요";
// 템플릿 리터럴 (ES6)
let greeting = `Hello, ${name}!`;
console.log(greeting);  // Hello, 자바스크립트!

// 여러 줄 문자열
let multiline = `첫 번째 줄
두 번째 줄
세 번째 줄
4
5`;
console.log(multiline);

// 표현식 삽입
let a = 10;
let b = 20;
console.log(`${a} + ${b} = ${a + b}`);  // 10 + 20 = 30

// 문자열 메서드
let str = '  Hello World  ';
console.log(str.trim());           // 'Hello World'
console.log(str.toUpperCase());    // '  HELLO WORLD  '
console.log(str.toLowerCase());    // '  hello world  '
console.log(str.includes('World')); // true
console.log(str.indexOf('o'));      // 6
console.log(str.replace('World', 'JS')); // '  Hello JS  '
console.log(str.split(' '));       // ['', '', 'Hello', 'World', '', '']


// null: 의도적으로 값이 없음
const emptyValue = null;
console.log(emptyValue);

// undefined: 값이 설정되지 않음
let notDefined;
console.log(notDefined);  // undefined


// 타입별 초기값
let num = NaN;
let text = "";
let flag = false;
let obj = {};       // 객체
let arr = [];     // 배열

// null: 진짜 없다.
// undefined: 아직 없다.
// "", [], NaN, 0, false: 비어있다.

// null != undefined