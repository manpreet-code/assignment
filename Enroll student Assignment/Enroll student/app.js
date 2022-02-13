function Student(name, email, website, imagelink, gender, skills) {
  this.name = name;
  this.email = email;
  this.website = website;
  this.imagelink = imagelink;
  this.gender = gender;
  this.skills = skills;
}

function UI() {}

UI.prototype.addStudentToList = function (student) {
  const list = document.getElementById("student-list");

  const row = document.createElement("tr");

  row.innerHTML = `
      <td>${student.name}<br/>
          ${student.gender}<br/>
          ${student.email}<br/>
          <a href="${student.website}" target="blank">${student.website}</a><br/>
          ${student.skills}</td>
          <td class="w-25"><img src="${student.imagelink}" class="img-fluid img-thumbnail"/></td>
        
    `;

  list.appendChild(row);
  row.classList.add("anim");
  var table = document.getElementById("form-table");
  table.classList.add("anim");
  document.getElementById("form-student").reset();
};

function Validatename(name) {
  var namecheck = /^[A-za-z. ]{3,30}$/;
  if (namecheck.test(name)) {
    return true;
  } else {
    return false;
  }
}

document
  .getElementById("form-student")
  .addEventListener("submit", function (e) {
    // Get form values
    const name = document.getElementById("name").value,
      email = document.getElementById("email").value,
      website = document.getElementById("website").value,
      imagelink = document.getElementById("imagelink").value;

    var radiochecked = document.getElementsByName("gender");
    var gender = "";
    for (var i = 0; i < radiochecked.length; i++) {
      if (radiochecked[i].checked) {
        gender += radiochecked[i].value;
      }
    }

    var skills = "";
    var arr = [];
    var checks = document.getElementsByName("skills");

    for (let i = 0; i < checks.length; i++) {
      if (checks[i].checked) {
        arr.push(checks[i].value);
      }
    }
    skills = arr.join(",");

    if (Validatename(name)) {
      const student = new Student(
        name,
        email,
        website,
        imagelink,
        gender,
        skills
      );

      const ui = new UI();

      ui.addStudentToList(student);
    } else {
      alert("Please input alphabet characters only in Name");
    }

    e.preventDefault();
  });
