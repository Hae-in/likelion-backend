// 배열 메서드

// forEach(함수)  --  요소를 하나씩 꺼내서 함수를 실행해주는 일
const array = [1, 2, 3, 4, 5];
// function print(number) {
//   console.log(number);
// }
const print = (number) => console.log(number * 2);

array.forEach(print); // forEach: array 내부 함수
// array.forEach(print()); // 함수 이름만 넘겨야 정상 실행 됨, print()는 print 함수 실행 값을 리턴 받음

// array.forEach((n) => console.log(n));

// array 배열의 요소에 (n * n) 한 결과 배열을 새로 만들고 싶다 [1, 4, 9, 16, 25]
const resultArr = [];
for (let i = 0; i < array.length; i++) {
    resultArr.push(array[i] * array[i]);
}
console.log(resultArr);

// foreach 이용: 각자 요소에다가 (뭔가(함수)) 해줘
console.log("╭───────────────────────── forEach ─────────────────────────╮");
const resultArrForEach = [];
array.forEach((n) => resultArrForEach.push(n * n));
console.log(resultArrForEach);
console.log("╰───────────────────────────────────────────────────────────╯");

// map 이용: 각각 요소를 바꿔줘 -> 바꾼 값들을 새 배열로 만들어서 리턴
console.log("╭─────────────────────────── map ───────────────────────────╮");
const resultMap = array.map((n) => n * n);
console.log(resultMap);
console.log("╰───────────────────────────────────────────────────────────╯");

// filter: 참인것만 배열에 담아서 리턴. (필터링, 조건선별)
console.log("╭────────────────────────── filter ─────────────────────────╮");
const resultFilter = array.filter((n) => n % 2 === 0);
console.log(resultFilter);
console.log("╰───────────────────────────────────────────────────────────╯");

// reduce: 누저 합
// const array = [1, 2, 3, 4, 5];
console.log("╭────────────────────────── reduce ─────────────────────────╮");
const resultReduce1 = array.reduce((a, c) => {
    console.log("a: " + a + ", c: " + c);
    return a + c;
}, 0); // 0: 시작값
console.log(resultReduce1);

// 시작값 x
const resultReduce2 = array.reduce((a, c) => {
    console.log("a: " + a + ", c: " + c);
    return a + c;
});
console.log(resultReduce2);
console.log("╰───────────────────────────────────────────────────────────╯");


const users = [
    { id: 1, name: '김철수' },
    { id: 2, name: '이영희' },
    { id: 3, name: '박민수' }
];

// find
console.log("╭─────────────────────────── find ──────────────────────────╮");
const user = users.find(u => u.id === 2);
console.log(user);  // { id: 2, name: '이영희' }
console.log("╰───────────────────────────────────────────────────────────╯");

// findIndex
console.log("╭───────────────────────── findIndex ───────────────────────╮");
const index = users.findIndex(u => u.id === 2);
console.log(index);  // 1
console.log("╰───────────────────────────────────────────────────────────╯");

// splice: 본 배열 수정
console.log("╭────────────────────────── splice ─────────────────────────╮");
const numbers = [10, 20, 30, 40];
const index = numbers.indexOf(30);
numbers.splice(index, 1);  // index부터 1개 제거
console.log(numbers);  // [10, 20, 40]
console.log("╰───────────────────────────────────────────────────────────╯");

// slice: 원본 배열 유지
console.log("╭─────────────────────────── slice ─────────────────────────╮");
const arr = [10, 20, 30, 40];
const sliced = arr.slice(0, 2);  // 0부터 2 전까지
console.log(sliced);  // [10, 20]
console.log(arr);     // [10, 20, 30, 40] (원본 유지)
console.log("╰───────────────────────────────────────────────────────────╯");

// shift: 첫 번째 요소 제거 및 반환
// numbers = [10, 20, 30, 40];
console.log("╭─────────────────────────── shift ─────────────────────────╮");
const first = numbers.shift();
console.log(first);    // 10
console.log(numbers);  // [20, 30, 40
console.log("╰───────────────────────────────────────────────────────────╯");

// pop: 마지막 요소 제거 및 반환
// numbers = [20, 30, 40];
console.log("╭──────────────────────────── pop ──────────────────────────╮");
const last = numbers.pop();
console.log(last);     // 40
console.log(numbers);  // [20, 30]
console.log("╰───────────────────────────────────────────────────────────╯");

// unshift: 앞에 추가
// numbers = [20, 30];
console.log("╭────────────────────────── unshift ────────────────────────╮");
numbers.unshift(5);
console.log(numbers);  // [5, 20, 30]
console.log("╰───────────────────────────────────────────────────────────╯");

// concat: 배열 합치기
console.log("╭────────────────────────── concat ─────────────────────────╮");
const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];
const combined = arr1.concat(arr2);
console.log(combined);  // [1, 2, 3, 4, 5, 6]
console.log("╰───────────────────────────────────────────────────────────╯");

// join: 문자열로 합치기
console.log("╭─────────────────────────── join ──────────────────────────╮");
const array = [1, 2, 3, 4, 5];
console.log(array.join());      // "1,2,3,4,5"
console.log(array.join(' '));   // "1 2 3 4 5"
console.log(array.join(' - '));  // "1 - 2 - 3 - 4 - 5"
console.log("╰───────────────────────────────────────────────────────────╯");

const fruits = ['사과', '바나나', '오렌지', '포도'];

// indexOf: 인덱스 찾기
console.log("╭────────────────────────── indexOf ────────────────────────╮");
console.log(fruits.indexOf('바나나'));  // 1
console.log(fruits.indexOf('수박'));    // -1 (없음)
console.log("╰───────────────────────────────────────────────────────────╯");

// includes: 포함 여부 확인
console.log("╭───────────────────────── includes ────────────────────────╮");
console.log(fruits.includes('오렌지'));  // true
console.log(fruits.includes('수박'));    // false
console.log("╰───────────────────────────────────────────────────────────╯");