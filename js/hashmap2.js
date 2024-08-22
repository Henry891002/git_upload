display()
    let result='';
    for(const key in this.map){
        result += `${key}: ${this.map[key]}\n`;
    }
    return result.trim();


const hashMap = new hashmap();

function put(){
const key =document.getElementById("keyInput").value.trim();
const value =document.getElementById("valueInput").value.trim();

if(key === ""){
    alert("KEY 不可為空!");
    return;
}

if(hashMap.contains(key)){
    alert("KEY 已存在，請用不同的 KEY!");
    return;
}

hashMap.put(key,value);
updateResult();
clearInputs();
}
function clearMap(){
hashMap.clear();
updateResult();
clearInputs();
}
function updateResult(){
const resultElement =document.getElementById("result");
resultElement.textContent=hashMap.display();
}

function clearInputs(){
document.getElementById("keyInput").value="";
document.getElementById("valueInput").value="";
} 

document.getElementById("putButton").addEventListener("click",put);
document.getElementById("clearButton").addEventListener("click",clearMap);
