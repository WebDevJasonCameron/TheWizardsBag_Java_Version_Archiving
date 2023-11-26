#!/bin/bash

# Set the path to the postgresql file directory
FILES_DIR="/Users/jasoncameron/IdeaProjects/TheWizardsBag/db/sql/run_sql"

# Loop through the files and execute them
for FILE in "$FILES_DIR"/*.sql; do
  echo "Running $File..."
  psql -U postgres -d the_wizards_bag -a -f "$FILE"
done

ehco "Database setup complete!"