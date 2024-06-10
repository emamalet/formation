# Comment créer des slides .adoc

Une fois que vous avez créé votre .adoc vous pouvez le transformer en .html pour l'ouvrir dans un navigateur en utilisant reveal.js.

```
npm init -y
npm i --save asciidoctor @asciidoctor/reveal.js
npx asciidoctor-revealjs index.adoc
```