let context = #{};

// Use the same switches, defaults, etc passed to this archetype, and pass them to the next
let render_settings = archetect::archetype::settings();

context += render(Archetype("org-prompts"), ANSWERS, render_settings);

context += render(Archetype("java-project-attributes"), ANSWERS + context + #{
    "project-suffix": "Assessor",
}, render_settings);


context += prompt(render("{{ org-solution-name }}-parent Version:", context), "platform-version", #{
    defaults_with: "1.0.0-SNAPSHOT",
});

context += set("service-port", 9010);
context += set("management-port", context["service-port"] + 1);
context += set("debug-port", context["service-port"] + 9);

if ANSWERS.model != () {
  context.model = ANSWERS.model;
} else {
  context.model = default_model(context);
}

if switch_enabled("debug-context") {
  print(as_yaml(context));
}

render(Directory("contents/base"), context);

render(Archetype("manifests"), context["artifact-id"], context);
render(Archetype("gitignore"), context["artifact-id"], #{ "ignore": ["java"]});

fn default_model(context) {
    let yaml = `
---
entities:
  '${context["project-prefix"]}':
    fields:
      "id":
        type: "String"
        optional: false
      "name":
        type: "String"
        optional: false
`;
    let model = from_yaml(yaml);
    model
}
