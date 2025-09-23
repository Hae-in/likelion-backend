// 연산자

// 산술 연산자
// 기본 산술
let a = 10 + 5;   // 15
console.log(a);
console.log(`${a}`);

let b = 10 - 5;   // 5
let c = 10 * 5;   // 50
let d = 10 / 5;   // 2
let e = 10 % 3;   // 1 (나머지)

// 증감 연산자
let count = 0;
count++;  // 1
++count;  // 2
count--;  // 1
--count;  // 0


// 비교 연산자
// 일치 비교 (타입까지 체크)
console.log(1 === 1);     // true
console.log(1 === '1');   // false

// 동등 비교 (타입 변환 후 비교) - 사용 비권장
console.log(1 == '1');    // true

// 불일치
console.log(1 !== '1');   // true

// 크기 비교
console.log(10 > 5);      // true
console.log(10 >= 10);    // true


// 논리 연산자
// AND (&&)
console.log(true && true);    // true
console.log(true && false);   // false

// OR (||)
console.log(true || false);   // true
console.log(false || false);  // false

// NOT (!)
console.log(!true);           // false
console.log(!false);          // true


// 삼항 연산자
// 조건 ? 참일때 : 거짓일때
const age = 20;
const status = age >= 18 ? '성인' : '미성년자';
console.log(status);  // 성인

// 중첩 삼항 연산자 (가독성 주의)
const score = 85;
const grade = score >= 90 ? 'A' :
    score >= 80 ? 'B' :
        score >= 70 ? 'C' : 'F';
console.log(grade);  // B