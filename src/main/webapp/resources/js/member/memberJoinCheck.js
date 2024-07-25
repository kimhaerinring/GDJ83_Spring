/**
 * 
 */
//변수 선언
 
 //명명함수 선언
//function 함수명(매개변수 선언){return}

//let, const
const btn = document.getElementById("btn");
const id = document.getElementById("id");
const ch =document.getElementsByClassName("ch");//배열 형식
const frm =document.getElementById("frm");
const pw = document.getElementById("password");
const rname = document.getElementById("name");
const phone = document.getElementById("phone");
const mail = document.getElementById("email");
const ss_num = document.getElementById("ss_num");
const pwerror = document.getElementById("pwerror");
const pweeqrror = document.getElementById("pweeqrror")
const pwc = document.getElementById("inputPasswordCheck");




pwc.addEventListener("blur", function(){
 	   pweeqrror.innerText="";

    if(pw.value != pwc.value){
        
        pweeqrror.innerText="Password가 일치 하지 않음";
        pwc.value="";
        return;
    }

 })
 
 btn.addEventListener("click", function(){
    pwerror.innerHTML="";
    if(id.value ==""){
        alert('ID는 필수 입니다');
        id.focus();
        return;
    }
    if(pw.value=="" || pw.value.length<6){

        pwerror.innerHTML="Password는 비어 있거나 6글자 이상이어야 함"
        pw.focus();
        return;
    }
  
 });
      








// btn.addEventListener("click",function(){
//     const checks = [false,false,false,false,false]
    
// for(let i=0;i<ch.length;i++){
   
//     if(ch[i].value!=""){
//         checks[i]=true;
//     }
//         }
//    let result = true;
//     for(let c of checks){

//     if(!c){
//         result= false;
//     }
//    }
//    if(result){
//     alert('Ok')
//     frm.submit();
//    }else{
//     alert('fail')
//    }
// });
