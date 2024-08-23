// hashmap1.js

// 定義 HashMap 結構
var HashMap = function () {
    let map = {};
    return {
        put: function (key, value) {
            map[key] = value;
        },
        keys: function () {
            return Object.keys(map);
        },
        contains: function (key) {
            return map.hasOwnProperty(key);
        },
        get: function (key) {
            return map[key];
        },
        clear: function () {
            map = {};
        }
    };
};


// 創建一個 HashMap 實例
var hashMap = new HashMap();

// 取得 DOM 元素
var keyInput = document.getElementById('keyInput');
var valueInput = document.getElementById('valueInput');
var result = document.getElementById('result');
var putButton = document.getElementById('putButton');
var clearButton = document.getElementById('clearButton');

// PUT 按鈕的點擊事件處理
putButton.addEventListener('click', function () {
    var key = keyInput.value.trim();
    var value = valueInput.value.trim();

    // 檢查 key 是否為空
    if (!key) {
        alert('KEY 不可空白');
        return;
    }

    // 檢查 key 是否已經存在於 HashMap 中
    if (hashMap.contains(key)) {
        alert('KEY 不能重覆');
        return;
    }

    // 使用 hashMap 的 put 方法將 key-value 添加到 HashMap 中
    hashMap.put(key, value);

    // 更新結果區域的顯示內容
    updateResult();
});

// CLEAR 按鈕的點擊事件處理
clearButton.addEventListener('click', function () {
    // 清空輸入框
    keyInput.value = '';
    valueInput.value = '';

    // 清空 HashMap 和結果區域
    hashMap.clear();
    updateResult();
});

// 更新結果區域的顯示內容
function updateResult() {
    var keys = hashMap.keys();
    var output = '';

    keys.forEach(function (key) {
        output += '' + key + ':' + '' + hashMap.get(key) + '\n';
    });

    result.textContent = output;
}
