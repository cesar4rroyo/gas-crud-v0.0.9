

const CLOUDINARY_URL="https://api.cloudinary.com/v1_1/dt77cgp7y/upload";
const CLOUDINARY_UPLOAD_PRESET="react-journal";
var imgPreview = document.getElementById("img-preview");
var fileUpload = document.getElementById("file-upload");
var btnAgregar = document.getElementById("btnAgregar");

fileUpload.addEventListener("change", (e)=>{
    const file = e.target.files[0];
    var formData = new FormData();
    formData.append("file", file);
    formData.append("upload_preset", CLOUDINARY_UPLOAD_PRESET );
    btnAgregar.disabled=true;
    axios({
       url: CLOUDINARY_URL,
       method: "POST",
       headers:{
           "Content-Type":"application/x-www-form-urlencoded"
       },
       data: formData
    }).then((res)=>{
       console.log(res);
       imgPreview.value=res.data.secure_url;
       btnAgregar.disabled=false;
    }).catch((e)=>{
       console.log(e); 
    });
    
    
});