export class Donation{
    constructor(private money:number, private projectId:number){}
   getMoney(){
      return this.money;
   }
   getProjectId(){
      return this.projectId;
   }
}