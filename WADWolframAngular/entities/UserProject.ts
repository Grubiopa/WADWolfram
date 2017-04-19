export class UserProject{
    private projectId:number;
    private title:string;
    private shortDescription:string;
    private money:number;

    constructor(id:number,title:string,shortDescription:string,money:number){
        this.projectId=id;
        this.title=title;
        this.shortDescription=shortDescription;
        this.money=money;
    }

    getProjectId(){
        return this.projectId;
    }
    getTitle(){
        return this.title;
    }
    getShortDescription(){
        return this.shortDescription;
    }
    getMoney(){
        return this.money;
    }
    
}