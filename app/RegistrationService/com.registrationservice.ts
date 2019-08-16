import {Injectable} from '@angular/core'
import { Observable } from 'rxjs'
import {HttpClient,HttpHeaders} from '@angular/common/http'

@Injectable({

    providedIn:'root'
})


export class RegistrationServiceComponent{

    URL:string="http://localhost:5000";

    constructor(private http:HttpClient){}

    addUser(account:any):Observable<any>{

        let data={"headers" : new HttpHeaders({"Content-Type":"application/json"})};

        return this.http.post(URL+"/addUser",account,data);
    }

    addAdmin(account:any):Observable<any>{

        let data={"headers" : new HttpHeaders({"Content-Type":"application/json"})};

        return this.http.post(URL+"/addAdmin",account,data);
    }

    addMerchant(account:any):Observable<any>{

        let data={"headers" : new HttpHeaders({"Content-Type":"application/json"})};

        return this.http.post(URL+"/addMerchant",account,data);
    }

}