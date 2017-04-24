export class UserMovements{
    public id:number;
    constructor(public projectTitle:string,public money:number,public date:Date){}
    getId(){
    return this.id;
  }
}
