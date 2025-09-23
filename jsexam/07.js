// 객체

// 객체 생성
const person = {
    name: '김철수',
    age: 25,
    city: '서울',
    isStudent: true
};

// 속성 접근
console.log(person.name);     // 김철수
console.log(person['age']);   // 25

// 속성 수정
person.age = 26;

// 속성 추가
person.email = 'kim@example.com';
console.log(person)

const dog = {
    name: "멍멍이",
    age: 2,
    sound: "야옹",
    say: function () {
        console.log(this.sound);
        console.log("say this" + this);
    },
    // say2: () => {
    //     console.log(this.sound);
    //     console.log("say this" + this); // 객체 안에서는 화살표 함수로 정의하면 안됨
    // }
};

console.log(dog);
dog.color = "검정색";
console.log(dog);
console.log(dog.name);
console.log(dog["name"]);
dog.say();
// dog.say2(); // undefined

const winTest = () => {
    console.log("객체 밖 ::: "  + this)
};

winTest();


// 객체 구조 분해
console.log("\n=== === === 객체 구조 분해 === === ===")
const user = {
    username: 'john',
    email: 'john@email.com',
    age: 30
};

// 구조 분해 할당: 순서는 중요하지않고, 이름이 중요
const { username, email, age } = user;
console.log(username);  // john
console.log(email, age);

// 함수 파라미터에서 구조 분해
function printUser({ username, age }) {
    console.log(`${username}님은 ${age}살입니다.`);
}
printUser(user);

// 객체 구조 분해 안했을 경우
function print(person) {
    const text = `${person.username}님은 ${person.age}살입니다 22.`;
    console.log(text);
}
print(user);


