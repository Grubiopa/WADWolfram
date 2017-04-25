export class UserMovements{
    private id:number;
    constructor(private projectTitle:string,private money:number,private date:Date){}
    getId(){
    return this.id;
  }
}
