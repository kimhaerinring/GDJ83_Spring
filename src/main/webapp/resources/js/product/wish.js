


const addWish = document.getElementById("addWish");
const wishResult = document.getElementById("wishResult");

//Arrow Function 화살표 함수 
//함수 선언 
//function [함수명] (){}
//()=>{}
addWish.addEventListener("click",(e)=>{
    let id =addWish.getAttribute("data-product-id")
   
        fetch("./addWish?id="+id,{
    method:"GET" 
     })
     .then((res)=>{return res.text()})
     .then((res)=>{
        if(res>0){
            let check =confirm("wish List 확인하겠습니까?");
            if(check){
                location.href="./wishList?p_code="+id;
               
            }
        }else{
            alert("wish List에 추가 실패")
        }
     })
     .catch(()=>{
        alert("오류발생");
     })
})



//function(res){ 
//return res.text()}

// addWish.addEventListener("click",function(){
//     fetch("./addWish?num=15&name=iu",{
//         method:"GET" 
//     })

// })