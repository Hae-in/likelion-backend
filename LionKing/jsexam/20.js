// 동기: 작업이 끝날 때까지 기다림
// 비동기: 작업을 시작하고 다른 작업 진행

console.log("시작!!!");

function work() {
    console.log("work 작업 시작!")
    const start = Date.now();
    for (let i = 0; i < 1000000000; i++) {}
    const end = Date.now();
    console.log(end - start + "ms");
    console.log("work 작업 끝!")

    console.log(end - start + "ms");
}

// work(); // 시간이 많이 걸리는 작업!!
// setTimeout(work, 1000); // 1초 딜레이
setTimeout(work, 0); // 0으로 해도 work 마지막에 작업

console.log("다음작업");

function hi() {
    console.log("hi");
}

hi();

console.log("다음 할일 1");
console.log("다음 할일 2");

console.log("끝!!");