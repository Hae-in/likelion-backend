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
console.log("╭────────────────────────── reduce ─────────────────────────╮")
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

