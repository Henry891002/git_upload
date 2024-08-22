class hashmap{
    constructor(){
        this.map={};
    }

    put(key,value){
        this.map[key]=value;
    }
    
    get(key){
        return this.map.hasOwnProperty(key)? this.map[key]:null;
    }

    contains(key){
        return this.map.hasOwnProperty(key);
    }

    clear(){
        this.map={};
    }
}