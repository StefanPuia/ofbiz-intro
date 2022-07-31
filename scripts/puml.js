const plantuml = require("node-plantuml");
const fs = require("fs");

fs.readdir("./diagrams", (err, files) => {
  if (err) {
    console.err(err);
    process.exitCode = 1;
    return;
  }
  files.forEach((file) => {
    const gen = plantuml.generate(`./diagrams/${file}`);
    const name = file.replace(/\.puml$/i, "");
    gen.out.pipe(fs.createWriteStream(`./images/diagrams/${name}.png`));
    console.log(`Generated ${name}`);
  });
});
