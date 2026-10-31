const user=JSON.parse(localStorage.getItem("erpUser")||'{"username":"Admin","role":"STAFF"}');
profileName.textContent=user.username||"User"; profileRole.textContent=user.role; avatar.textContent=(user.username||"U")[0].toUpperCase();
const configs={
students:{title:"Students",endpoint:"/students",fields:[["name","Full Name","text"],["email","Email","email"],["department","Department","text"],["year","Year","number"],["phone","Phone","text"]],cols:["id","name","email","department","year"]},
teachers:{title:"Teachers",endpoint:"/teachers",fields:[["name","Full Name","text"],["email","Email","email"],["department","Department","text"],["designation","Designation","text"],["phone","Phone","text"]],cols:["id","name","email","department","designation"]},
courses:{title:"Courses",endpoint:"/courses",fields:[["code","Course Code","text"],["name","Course Name","text"],["department","Department","text"],["credits","Credits","number"],["teacherId","Teacher ID","number"]],cols:["id","code","name","department","credits"]},
attendance:{title:"Attendance",endpoint:"/attendance",fields:[["studentId","Student ID","number"],["courseId","Course ID","number"],["date","Date","date"],["present","Present (true/false)","text"]],cols:["id","studentId","courseId","date","present"]},
marks:{title:"Marks & Results",endpoint:"/marks",fields:[["studentId","Student ID","number"],["courseId","Course ID","number"],["internalMark","Internal Mark","number"],["examMark","Exam Mark","number"]],cols:["id","studentId","courseId","internalMark","examMark"]},
announcements:{title:"Announcements",endpoint:"/announcements",fields:[["title","Title","text"],["message","Message","text"],["audience","Audience","text"]],cols:["id","title","audience","createdAt"]}
};
let current=null,editId=null;
document.querySelectorAll("nav a[data-page]").forEach(a=>a.onclick=()=>{document.querySelectorAll("nav a").forEach(x=>x.classList.remove("active"));a.classList.add("active");loadPage(a.dataset.page)});
logout.onclick=()=>localStorage.removeItem("erpUser"); closeModal.onclick=()=>modal.classList.add("hidden");
function esc(v){return String(v??"").replace(/[&<>"']/g,c=>({"&":"&amp;","<":"&lt;",">":"&gt;",'"':"&quot;","'":"&#39;"}[c]))}
async function loadPage(page){
 if(page==="dashboard"){current=null;const s=await apiRequest("/dashboard/summary");content.innerHTML=`<div class="hero"><h1>Good day, ${esc(user.username)} 👋</h1><p>Here's what's happening across your college today.</p></div><div class="stats">${stat("Students",s.students)}${stat("Teachers",s.teachers)}${stat("Courses",s.courses)}${stat("Notices",s.announcements)}</div><div class="panel"><h3>College ERP Overview</h3><p>Use the sidebar to manage academic and administrative records through Spring Boot REST APIs.</p></div>`;return}
 current=page;const c=configs[page];content.innerHTML=`<div class="hero"><div><h1>${c.title}</h1><p>Manage ${c.title.toLowerCase()} records.</p></div><button class="add" onclick="openCreate()">+ Add ${c.title.slice(0,-1)}</button></div><div class="panel"><input id="search" class="search" placeholder="Search records..."><div id="table">Loading...</div></div>`;
 const data=await apiRequest(c.endpoint); render(data); search.oninput=()=>render(data);
}
function stat(label,value){return `<div class="stat"><small>${label}</small><strong>${value}</strong><span>Active records</span></div>`}
function render(data){const c=configs[current],q=(search?.value||"").toLowerCase(),rows=data.filter(x=>JSON.stringify(x).toLowerCase().includes(q));table.innerHTML=`<table><thead><tr>${c.cols.map(x=>`<th>${x}</th>`).join("")}<th>Actions</th></tr></thead><tbody>${rows.map(x=>`<tr>${c.cols.map(k=>`<td>${esc(x[k])}</td>`).join("")}<td><button class="action" onclick="openEdit(${x.id})">Edit</button><button class="action danger" onclick="removeItem(${x.id})">Delete</button></td></tr>`).join("")||"<tr><td>No records found.</td></tr>"}</tbody></table>`}
function openCreate(){editId=null;showForm({})}
async function openEdit(id){editId=id;showForm(await apiRequest(configs[current].endpoint+"/"+id))}
function showForm(item){const c=configs[current];modalTitle.textContent=(editId?"Edit ":"Add ")+c.title.slice(0,-1);recordForm.innerHTML=`<div class="form-grid">${c.fields.map(f=>`<div><label>${f[1]}</label><input name="${f[0]}" type="${f[2]}" value="${esc(item[f[0]]??"")}"></div>`).join("")}<button type="submit">Save</button></div>`;modal.classList.remove("hidden");recordForm.onsubmit=async e=>{e.preventDefault();const data={};new FormData(recordForm).forEach((v,k)=>data[k]=["year","credits","teacherId","studentId","courseId","internalMark","examMark"].includes(k)?Number(v):k==="present"?v==="true":v);const c=configs[current];await apiRequest(c.endpoint+(editId?"/"+editId:""),{method:editId?"PUT":"POST",body:JSON.stringify(data)});modal.classList.add("hidden");loadPage(current)}}
async function removeItem(id){if(confirm("Delete this record?")){await apiRequest(configs[current].endpoint+"/"+id,{method:"DELETE"});loadPage(current)}}
loadPage("dashboard");
