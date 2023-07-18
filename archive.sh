set -uvx
set -e
rm -rf ~/cmd/java-tmpl.zip
git archive HEAD -o ~/cmd/java8-tmpl.zip
