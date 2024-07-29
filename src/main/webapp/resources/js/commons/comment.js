const commentContents = document.getElementById("commentContents")
const commentButton = document.getElementById("commentButton")
const commentClose = document.getElementById("commentClose")
const commentList = document.getElementById("commentList")
const openModal = document.getElementById("openModal")

getList(1);

function getList(page) {
    fetch("commentList?p_code=" + commentButton.getAttribute("data-id") + "&page=" + page, {
        method: "GET"
    })
        .then(r => r.text())
        .then(r => commentList.innerHTML = r)
}
commentList.addEventListener("click", (e) => {
    e.preventDefault();
    if (e.target.classList.contains("pn")) {
        let p = e.target.getAttribute("data-page-num")
        getList(p);
    }
})
//true : 등록 , false: 수정
let flag = true;
let bn = 0;
openModal.addEventListener("click", () => {
    flag = true;
    commentButton.innerHTML = "댓글 등록";
    commentContents.value = "";
})

//수정
commentList.addEventListener("click", (e) => {
    if (e.target.classList.contains("ups")) {
        flag = false;
        bn = e.target.getAttribute("data-comment-del");
        let c = e.target.getAttribute("data-update-con");
        console.log(c);
        c = document.getElementById(c).innerHTML;
        commentContents.value = c;
        commentButton.innerHTML = "댓글 수정";
    }
})




commentList.addEventListener("click", (e) => {
    if (e.target.classList.contains("del")) {
        let id = e.target.getAttribute("data-comment-del");
        fetch("commentDelete", {
            method: "POST",
            headers: {
                "Content-type": "application/x-www-form-urlencoded"
            },
            body: "comments_num=" + id
        })
            .then(r => r.text())
            .then(r => {
                r = r.trim();
                if (r > 0) {
                    alert('성공')
                    getList(1)
                }
            })
    }

})


//등록 ,수정                                                                                 
commentButton.addEventListener("click", () => {
    let contents = commentContents.value;
    if (contents == null || contents == "") {
        alert("댓글 입력")
        return;
    }
    let url = "commentAdd";

        const form = new FormData();//<form>
        form.append("comments_Content",contents);//<input type="text" name ="comments_Content", value ="contents값">
        form.append("p_code",commentButton.getAttribute("data-id"));
        form.append("comments_num",bn);
    //let param = "comments_Content=" + contents + "&p_code=" + commentButton.getAttribute("data-id");

    if (!flag) {
        url = "commentUpdate";
      //  param = "comments_Content=" + contents + "&comments_num=" + bn;
    }

    
    
    fetch(url, {
        method: "POST",
        // headers: {
        //     "Content-type": "application/x-www-form-urlencoded"
        // },
        body:form
    })
    .then(r => r.text())
    .then(r => {
        r = r.trim();
        if (r > 0) {
            getList(1);
        }
    })
    
    commentContents.value = "";
    commentClose.click();

})
